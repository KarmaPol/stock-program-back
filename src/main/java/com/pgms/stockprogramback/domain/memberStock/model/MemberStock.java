package com.pgms.stockprogramback.domain.memberStock.model;

import com.pgms.stockprogramback.domain.member.model.Member;
import com.pgms.stockprogramback.domain.stock.model.Stock;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.List;

@Entity
public class MemberStock {
    @Id
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;
    @ManyToOne(fetch = FetchType.LAZY)
    private Stock stock;
    private int quantity;
}
