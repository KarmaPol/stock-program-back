package com.pgms.stockprogramback.domain.buyReserve.model;

import com.pgms.stockprogramback.domain.member.model.Member;
import com.pgms.stockprogramback.domain.stock.model.Stock;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class BuyReserve {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Member buyer;
    @OneToOne
    private Stock stock;
    private Integer quantity;
    private Integer price;
}
