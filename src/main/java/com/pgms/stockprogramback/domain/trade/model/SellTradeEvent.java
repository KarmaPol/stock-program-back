package com.pgms.stockprogramback.domain.trade.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SellTradeEvent {
    private Trade trade;
}
