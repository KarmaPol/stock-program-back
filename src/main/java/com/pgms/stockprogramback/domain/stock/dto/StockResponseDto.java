package com.pgms.stockprogramback.domain.stock.dto;

public record StockResponseDto(Long stockId, String name, Integer highPrice, Integer lowPrice, Integer currentPrice) {
}
