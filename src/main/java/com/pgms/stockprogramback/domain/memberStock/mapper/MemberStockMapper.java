package com.pgms.stockprogramback.domain.memberStock.mapper;

import com.pgms.stockprogramback.domain.memberStock.dto.MemberStockResponseDto;
import com.pgms.stockprogramback.domain.memberStock.model.MemberStock;
import com.pgms.stockprogramback.domain.stock.dto.StockResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberStockMapper {
    MemberStockResponseDto memberStockToMemberStockResponseDto(MemberStock memberStock, StockResponseDto stockResponseDto);
}
