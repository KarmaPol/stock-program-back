package com.pgms.stockprogramback.domain.stock.repository;

import com.pgms.stockprogramback.domain.stock.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
