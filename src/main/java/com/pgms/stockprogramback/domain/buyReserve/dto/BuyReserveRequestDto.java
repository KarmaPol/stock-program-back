package com.pgms.stockprogramback.domain.buyReserve.dto;

public record BuyReserveRequestDto(Long stockId, Long memberId, Integer quantity, Integer price) {
}
