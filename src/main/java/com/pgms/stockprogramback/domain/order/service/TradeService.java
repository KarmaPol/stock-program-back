package com.pgms.stockprogramback.domain.order.service;

import com.pgms.stockprogramback.domain.order.dto.TradeBuyRequestDto;
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
    private final TradeRepository tradeRepository;

    // todo 수량 체크, 거래 상태 체크
    public void buyOrder(TradeBuyRequestDto tradeBuyRequestDto) {
        Stock stock = stockService.getStock(tradeBuyRequestDto.stockId());

        stock.changeInfo(tradeBuyRequestDto.getPrice());
    }

    public void sellOrder(TradeBuyRequestDto tradeBuyRequestDto) {

    }
}
