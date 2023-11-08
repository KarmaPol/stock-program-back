package com.pgms.stockprogramback.domain.trade.controller;

import com.pgms.stockprogramback.domain.trade.dto.TradeBuyRequestDto;
import com.pgms.stockprogramback.domain.trade.dto.TradeSellRequestDto;
import com.pgms.stockprogramback.domain.trade.service.TradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TradeController {

    private final TradeService tradeService;

    @PostMapping("/order/long")
    public void buyOrder(TradeBuyRequestDto tradeBuyRequestDto){
        tradeService.buyOrder(tradeBuyRequestDto);
    }

    @PostMapping("/order/short")
    public void sellOrder(TradeSellRequestDto tradeSellRequestDto){
        tradeService.sellOrder(tradeSellRequestDto);
    }
}
