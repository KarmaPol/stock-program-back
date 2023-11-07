package com.pgms.stockprogramback.domain.memberStock.repository;

import com.pgms.stockprogramback.domain.memberStock.model.MemberStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberStockRepository extends JpaRepository<MemberStock, Long> {
}
