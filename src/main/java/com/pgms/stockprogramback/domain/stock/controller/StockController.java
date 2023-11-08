package com.pgms.stockprogramback.domain.stock.controller;

import com.pgms.stockprogramback.domain.stock.dto.StockResponseDto;
import com.pgms.stockprogramback.domain.stock.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @GetMapping("/stocks")
    public List<StockResponseDto> getStockLists(){
        return stockService.getStockList();
    }
}
