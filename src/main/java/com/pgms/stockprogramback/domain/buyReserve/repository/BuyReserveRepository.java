package com.pgms.stockprogramback.domain.buyReserve.repository;

import com.pgms.stockprogramback.domain.buyReserve.model.BuyReserve;
import com.pgms.stockprogramback.domain.member.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuyReserveRepository extends JpaRepository<BuyReserve, Long> {

    List<BuyReserve> findBuyReservesByMember(Member member);
}
