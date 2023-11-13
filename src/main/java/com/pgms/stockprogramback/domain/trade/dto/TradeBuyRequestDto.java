package com.pgms.stockprogramback.domain.trade.dto;

public record TradeBuyRequestDto(Integer price, Integer quantity, Long memberId, Long tradeId) {
}
