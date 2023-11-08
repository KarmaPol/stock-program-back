package com.pgms.stockprogramback.domain.trade.mapper;

import com.pgms.stockprogramback.domain.stock.dto.StockResponseDto;
import com.pgms.stockprogramback.domain.trade.dto.TradeResponseDto;
import com.pgms.stockprogramback.domain.trade.model.Trade;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TradeMapper {

    TradeResponseDto tradeToTradeResponseDto(Trade trade, StockResponseDto stockResponseDto);
}
