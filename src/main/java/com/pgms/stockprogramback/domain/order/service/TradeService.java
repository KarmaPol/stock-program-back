package com.pgms.stockprogramback.domain.order.service;

import com.pgms.stockprogramback.domain.member.model.Member;
import com.pgms.stockprogramback.domain.member.service.MemberService;
import com.pgms.stockprogramback.domain.memberStock.model.MemberStock;
import com.pgms.stockprogramback.domain.order.dto.TradeBuyRequestDto;
import com.pgms.stockprogramback.domain.order.dto.TradeSellRequestDto;
import com.pgms.stockprogramback.domain.order.model.Trade;
import com.pgms.stockprogramback.domain.order.repository.TradeRepository;
import com.pgms.stockprogramback.domain.stock.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TradeService {

    private final StockService stockService;
    private final MemberService memberService;
    private final TradeRepository tradeRepository;

    public Trade getTrade(Long id){
        return tradeRepository.findById(id).orElseThrow(() -> new RuntimeException("존재하지 않는 거래입니다."));
    }

    public void buyOrder(TradeBuyRequestDto tradeBuyRequestDto) {
        Trade trade = getTrade(tradeBuyRequestDto.TradeId());

        isValidTrade(tradeBuyRequestDto, trade);

        // member가 이미 보유 중인 stock은 quantity만 추가
        Member member = memberService.getMember(tradeBuyRequestDto.memberId());
        member.getMemberStocks().stream()
                .filter(s -> s.getStock().getId().equals(trade.getStock().getId())).findAny()
                .ifPresentOrElse((s) -> s.addStock(tradeBuyRequestDto.quantity()),
                        () -> member.getMemberStocks().add(new MemberStock(member, trade.getStock(), trade.getQuantity())));

        trade.sellStock(tradeBuyRequestDto.quantity());
        // 거래 성사 시 stock 시가 조정
        trade.getStock().changeInfo(trade.getPrice());
    }

    private void isValidTrade(TradeBuyRequestDto tradeBuyRequestDto, Trade trade) {
        if(trade.getIsTraded())
            throw new RuntimeException("완료된 거래입니다.");
        if(trade.getPrice() > tradeBuyRequestDto.price())
            throw new RuntimeException("invalid input");
        if(trade.getQuantity() > tradeBuyRequestDto.quantity())
            throw new RuntimeException("invalid input");
    }

    public void sellOrder(TradeSellRequestDto tradeSellRequestDto) {
        Member member = memberService.getMember(tradeSellRequestDto.memberId());
        MemberStock memberStock = member.getMemberStocks().stream()
                .filter(s -> s.getStock().getId().equals(tradeSellRequestDto.stockId()) && s.getQuantity() >= tradeSellRequestDto.quantity()).findAny()
                .orElseThrow(() -> new RuntimeException("보유 수량이 부족합니다."));

        memberStock.sellStock(tradeSellRequestDto.quantity());

        Trade trade = Trade.builder().stock(memberStock.getStock()).quantity(tradeSellRequestDto.quantity()).build();
        tradeRepository.save(trade);
    }
}
