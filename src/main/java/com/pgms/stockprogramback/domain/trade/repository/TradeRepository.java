package com.pgms.stockprogramback.domain.trade.repository;

import com.pgms.stockprogramback.domain.trade.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeRepository extends JpaRepository<Trade, Long> {
}
