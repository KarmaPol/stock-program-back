package com.pgms.stockprogramback.domain.trade.dto;

public record TradeResponseDto(Long id, Integer price, Integer quantity, Boolean isTraded, Long stockId){}
