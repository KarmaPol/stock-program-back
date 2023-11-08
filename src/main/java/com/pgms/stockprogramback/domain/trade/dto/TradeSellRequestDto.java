package com.pgms.stockprogramback.domain.trade.dto;

public record TradeSellRequestDto(Integer price, Integer quantity, Long memberId, Long stockId) {
}
