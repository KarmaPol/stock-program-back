package com.pgms.stockprogramback.domain.member.repository;

import com.pgms.stockprogramback.domain.member.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
