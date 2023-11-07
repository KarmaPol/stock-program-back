package com.pgms.stockprogramback.domain.order.service;

import com.pgms.stockprogramback.domain.member.model.Member;
import com.pgms.stockprogramback.domain.member.service.MemberService;
import com.pgms.stockprogramback.domain.memberStock.model.MemberStock;
import com.pgms.stockprogramback.domain.order.dto.TradeBuyRequestDto;
import com.pgms.stockprogramback.domain.order.dto.TradeSellRequestDto;
import com.pgms.stockprogramback.domain.order.model.Trade;
import com.pgms.stockprogramback.domain.order.repository.TradeRepository;
import com.pgms.stockprogramback.domain.stock.model.Stock;
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

    // todo 수량 체크, 거래 상태 체크, 가격 체크
    public void buyOrder(TradeBuyRequestDto tradeBuyRequestDto) {
        Stock stock = stockService.getStock(tradeBuyRequestDto.stockId());

        stock.changeInfo(tradeBuyRequestDto.getPrice());
    }

    // 판매자의 수량 체크
    public void sellOrder(TradeSellRequestDto tradeBuyRequestDto) {
        Member member = memberService.getMember(tradeBuyRequestDto.memberId());
        MemberStock memberStock = member.getMemberStocks().stream()
                .filter(s -> s.getStock().getId().equals(tradeBuyRequestDto.stockId()) && s.getQuantity() >= tradeBuyRequestDto.quantity()).findAny()
                .orElseThrow(() -> new RuntimeException("보유 수량이 부족합니다."));

        memberStock.sellStock(tradeBuyRequestDto.quantity());

        Trade trade = Trade.builder().stocks(memberStock.getStock()).quantity(tradeBuyRequestDto.quantity()).build();
        tradeRepository.save(trade);
    }
}
