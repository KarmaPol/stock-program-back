package com.pgms.stockprogramback.domain.memberStock.repository;

import com.pgms.stockprogramback.domain.member.model.Member;
import com.pgms.stockprogramback.domain.memberStock.model.MemberStock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberStockRepository extends JpaRepository<MemberStock, Long> {
}
