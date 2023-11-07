package com.pgms.stockprogramback.domain.order.dto;

import lombok.Getter;

@Getter
public record TradeSellRequestDto(Integer price, Integer quantity, Long memberId, Long stockId) {
}