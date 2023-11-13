package com.pgms.stockprogramback.domain.buyReserve.model;

import com.pgms.stockprogramback.domain.member.model.Member;
import com.pgms.stockprogramback.domain.stock.model.Stock;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BuyReserve {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Member member;
    @ManyToOne
    private Stock stock;
    private Integer quantity;
    private Integer price;

    public BuyReserve(Member member, Stock stock, Integer quantity, Integer price) {
        this.member = member;
        this.stock = stock;
        this.quantity = quantity;
        this.price = price;
    }
}
