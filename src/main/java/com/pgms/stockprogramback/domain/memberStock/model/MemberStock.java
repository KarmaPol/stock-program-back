package com.pgms.stockprogramback.domain.memberStock.model;

import com.pgms.stockprogramback.domain.member.model.Member;
import com.pgms.stockprogramback.domain.stock.model.Stock;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.util.List;


@Entity
@Getter
public class MemberStock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;
    @ManyToOne(fetch = FetchType.LAZY)
    private Stock stock ;
    private int quantity;

    public MemberStock(Member member, Stock stock, int quantity) {
        this.member = member;
        this.stock = stock;
        this.quantity = quantity;
    }

    public MemberStock() {

    }

    public void sellStock(Integer quantity) {
        this.quantity -= quantity;
        if(quantity == 0)
            member.getMemberStocks().remove(this);
    }

    public void addStock(Integer quantity) {
        this.quantity += quantity;
    }
}
