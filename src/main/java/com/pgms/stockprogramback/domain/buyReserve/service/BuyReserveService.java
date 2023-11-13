package com.pgms.stockprogramback.domain.buyReserve.service;

import com.pgms.stockprogramback.domain.buyReserve.dto.BuyReserveRequestDto;
import com.pgms.stockprogramback.domain.buyReserve.dto.BuyReserveResponseDto;
import com.pgms.stockprogramback.domain.buyReserve.model.BuyReserve;
import com.pgms.stockprogramback.domain.buyReserve.repository.BuyReserveCustomRepository;
import com.pgms.stockprogramback.domain.buyReserve.repository.BuyReserveRepository;
import com.pgms.stockprogramback.domain.member.model.Member;
import com.pgms.stockprogramback.domain.member.service.MemberService;
import com.pgms.stockprogramback.domain.stock.mapper.StockMapper;
import com.pgms.stockprogramback.domain.stock.model.Stock;
import com.pgms.stockprogramback.domain.stock.service.StockService;
import com.pgms.stockprogramback.domain.trade.dto.TradeBuyRequestDto;
import com.pgms.stockprogramback.domain.trade.model.SellTradeEvent;
import com.pgms.stockprogramback.domain.trade.model.Trade;
import com.pgms.stockprogramback.domain.trade.service.TradeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class BuyReserveService {

    private final BuyReserveRepository buyReserveRepository;
    private final BuyReserveCustomRepository buyReserveCustomRepository;
    private final TradeService tradeService;
    private final MemberService memberService;
    private final StockService stockService;
    private final StockMapper stockMapper;

    @EventListener
    public void sellEventListener(SellTradeEvent event){
        log.info(">>>>>> Buy Reservation Event");

        Trade trade = event.getTrade();

        // trade 보다 주문 수량이 적고, 주문 가격이 높은 buyReserve 를 가져온다
        buyReserveCustomRepository.findBuyReserveByStockAndPrice(trade.getStock(), trade.getPrice(), trade.getQuantity())
                .ifPresent(buyReserve ->
                {
                    TradeBuyRequestDto tradeBuyRequestDto = new TradeBuyRequestDto(buyReserve.getPrice(), buyReserve.getQuantity(), buyReserve.getMember().getId(), trade.getId());
                    tradeService.buyOrder(tradeBuyRequestDto);
                    buyReserveRepository.delete(buyReserve);
                });
    }

    public List<BuyReserveResponseDto> getBuyReserveListByMember(Long id){
        Member member = memberService.getMember(id);
        return buyReserveRepository.findBuyReservesByMember(member).stream().map(r ->
            new BuyReserveResponseDto(r.getId(), stockMapper.stockToStockResponseDto(r.getStock()), r.getQuantity(), r.getPrice())
        ).toList();
    }

    public void postBuyReserve(BuyReserveRequestDto buyReserveRequestDto){
        Member member = memberService.getMember(buyReserveRequestDto.memberId());
        Stock stock = stockService.getStock(buyReserveRequestDto.stockId());
        BuyReserve buyReserve = new BuyReserve(member, stock, buyReserveRequestDto.quantity(), buyReserveRequestDto.price());
        buyReserveRepository.save(buyReserve);
    }
}
