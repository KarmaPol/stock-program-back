package com.pgms.stockprogramback.domain.order.dto;

import lombok.Getter;

public record TradeBuyRequestDto(Integer price, Integer quantity, Long memberId, Long TradeId) {
}
