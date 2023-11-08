package com.pgms.stockprogramback.domain.buyReserve.service;

import com.pgms.stockprogramback.domain.buyReserve.dto.BuyReserveResponseDto;
import com.pgms.stockprogramback.domain.buyReserve.repository.BuyReserveCustomRepository;
import com.pgms.stockprogramback.domain.buyReserve.repository.BuyReserveRepository;
import com.pgms.stockprogramback.domain.trade.dto.TradeBuyRequestDto;
import com.pgms.stockprogramback.domain.trade.model.Trade;
import com.pgms.stockprogramback.domain.trade.service.TradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BuyReserveService {

    private final BuyReserveRepository buyReserveRepository;
    private final BuyReserveCustomRepository buyReserveCustomRepository;
    private final TradeService tradeService;

    @TransactionalEventListener
    public void sellEventListener(Trade trade){
        // trade 보다 주문 수량이 적고, 주문 가격이 높은 buyReserve 를 가져온다
        buyReserveCustomRepository.findBuyReserveByStockAndPrice(trade.getStock(), trade.getPrice(), trade.getQuantity())
                .ifPresent(buyReserve ->
                {
                    TradeBuyRequestDto tradeBuyRequestDto = new TradeBuyRequestDto(buyReserve.getPrice(), buyReserve.getQuantity(), buyReserve.getBuyer().getId(), trade.getId());
                    tradeService.buyOrder(tradeBuyRequestDto);
                    buyReserveRepository.delete(buyReserve);
                });
    }
}
