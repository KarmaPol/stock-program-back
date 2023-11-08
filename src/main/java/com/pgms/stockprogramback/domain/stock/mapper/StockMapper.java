package com.pgms.stockprogramback.domain.stock.mapper;

import com.pgms.stockprogramback.domain.stock.dto.StockResponseDto;
import com.pgms.stockprogramback.domain.stock.model.Stock;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StockMapper {
    StockResponseDto stockToStockResponseDto(Stock stock);
}
