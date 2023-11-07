package com.pgms.stockprogramback.domain.order.repository;

import com.pgms.stockprogramback.domain.order.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeRepository extends JpaRepository<Trade, Long> {
}
