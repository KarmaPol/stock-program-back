package com.pgms.stockprogramback.domain.memberStock.dto;

import com.pgms.stockprogramback.domain.member.model.Member;
import com.pgms.stockprogramback.domain.stock.dto.StockResponseDto;
import com.pgms.stockprogramback.domain.stock.model.Stock;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;

public record MemberStockResponseDto(Long id, StockResponseDto stockResponseDto, int quantity) {
}
