package com.pgms.stockprogramback.domain.trade.service;

import com.pgms.stockprogramback.domain.member.model.Member;
import com.pgms.stockprogramback.domain.member.service.MemberService;
import com.pgms.stockprogramback.domain.memberStock.model.MemberStock;
import com.pgms.stockprogramback.domain.memberStock.repository.MemberStockRepository;
import com.pgms.stockprogramback.domain.stock.mapper.StockMapper;
import com.pgms.stockprogramback.domain.trade.dto.TradeBuyRequestDto;
import com.pgms.stockprogramback.domain.trade.dto.TradeResponseDto;
import com.pgms.stockprogramback.domain.trade.dto.TradeSellRequestDto;
import com.pgms.stockprogramback.domain.trade.mapper.TradeMapper;
import com.pgms.stockprogramback.domain.trade.model.Trade;
import com.pgms.stockprogramback.domain.trade.repository.TradeRepository;
import com.pgms.stockprogramback.domain.stock.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TradeService {

    private final StockService stockService;
    private final MemberService memberService;
    private final TradeRepository tradeRepository;
    private final TradeMapper tradeMapper;
    private final StockMapper stockMapper;
    private final MemberStockRepository memberStockRepository;

    public Trade getTrade(Long id){
        return tradeRepository.findById(id).orElseThrow(() -> new RuntimeException("존재하지 않는 거래입니다."));
    }

    public void buyOrder(TradeBuyRequestDto tradeBuyRequestDto) {
        Trade trade = getTrade(tradeBuyRequestDto.tradeId());

        isValidTrade(tradeBuyRequestDto, trade);

        // member가 이미 보유 중인 stock은 quantity만 추가
        Member member = memberService.getMember(tradeBuyRequestDto.memberId());
        MemberStock memberStock = new MemberStock(member, trade.getStock(), trade.getQuantity());
        member.getMemberStocks().stream()
                .filter(s -> s.getStock().getStockId().equals(trade.getStock().getStockId()))
                .findAny()
                .ifPresentOrElse(
                    (s) -> s.addStock(tradeBuyRequestDto.quantity()),
                    () -> {
                        member.getMemberStocks().add(memberStock);
                        memberStockRepository.save(memberStock);
                    }
                );

        trade.sellStock(tradeBuyRequestDto.quantity());
        // 거래 성사 시 stock 시가 조정
        trade.getStock().changeInfo(trade.getPrice());
    }

    private void isValidTrade(TradeBuyRequestDto tradeBuyRequestDto, Trade trade) {
        if(trade.getIsTraded())
            throw new RuntimeException("완료된 거래입니다.");
        if(trade.getPrice() > tradeBuyRequestDto.price())
            throw new RuntimeException("invalid input");
        if(trade.getQuantity() < tradeBuyRequestDto.quantity())
            throw new RuntimeException("invalid input");
    }

    public void sellOrder(TradeSellRequestDto tradeSellRequestDto) {
        Member member = memberService.getMember(tradeSellRequestDto.memberId());
        MemberStock memberStock = member.getMemberStocks().stream()
                .filter(s -> s.getStock().getStockId().equals(tradeSellRequestDto.stockId()) && s.getQuantity() >= tradeSellRequestDto.quantity()).findAny()
                .orElseThrow(() -> new RuntimeException("보유 수량이 부족합니다."));

        memberStock.sellStock(tradeSellRequestDto.quantity());

        Trade trade = Trade.builder().stock(memberStock.getStock()).quantity(tradeSellRequestDto.quantity()).build();
        tradeRepository.save(trade);
    }

    public List<TradeResponseDto> getTrades(){
        return tradeRepository.findAll().stream().map(t -> tradeMapper.tradeToTradeResponseDto(t, stockMapper.stockToStockResponseDto(t.getStock()))).toList();
    }
}
