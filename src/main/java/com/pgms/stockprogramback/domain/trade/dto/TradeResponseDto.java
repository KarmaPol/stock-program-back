package com.pgms.stockprogramback.domain.trade.dto;

import com.pgms.stockprogramback.domain.stock.dto.StockResponseDto;

public record TradeResponseDto(Long id, Integer price, Integer quantity, Boolean isTraded, StockResponseDto stockResponseDto){}
