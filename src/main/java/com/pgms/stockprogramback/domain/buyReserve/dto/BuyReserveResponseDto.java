package com.pgms.stockprogramback.domain.buyReserve.dto;

import com.pgms.stockprogramback.domain.stock.dto.StockResponseDto;

public record BuyReserveResponseDto(Long id, StockResponseDto stockResponseDto, Integer quantity, Integer price) {
}
