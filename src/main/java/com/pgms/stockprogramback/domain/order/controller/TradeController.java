package com.pgms.stockprogramback.domain.order.controller;

import com.pgms.stockprogramback.domain.order.dto.TradeBuyRequestDto;
import com.pgms.stockprogramback.domain.order.service.TradeService;
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
    public void sellOrder(TradeBuyRequestDto tradeBuyRequestDto){
        tradeService.sellOrder(tradeBuyRequestDto);
    }
}
