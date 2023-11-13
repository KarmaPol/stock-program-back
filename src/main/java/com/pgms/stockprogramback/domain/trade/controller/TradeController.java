package com.pgms.stockprogramback.domain.trade.controller;

import com.pgms.stockprogramback.domain.trade.dto.TradeBuyRequestDto;
import com.pgms.stockprogramback.domain.trade.dto.TradeResponseDto;
import com.pgms.stockprogramback.domain.trade.dto.TradeSellRequestDto;
import com.pgms.stockprogramback.domain.trade.service.TradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TradeController {

    private final TradeService tradeService;

    @PostMapping("/trades/long")
    public void buyOrder(TradeBuyRequestDto tradeBuyRequestDto){
        tradeService.buyOrder(tradeBuyRequestDto);
    }

    @PostMapping("/trades/short")
    public void sellOrder(TradeSellRequestDto tradeSellRequestDto){
        tradeService.sellOrder(tradeSellRequestDto);
    }

    @GetMapping("/trades")
    public List<TradeResponseDto> getTradeList(){
        return tradeService.getTrades();
    }
}
