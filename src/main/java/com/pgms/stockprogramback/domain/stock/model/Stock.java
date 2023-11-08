package com.pgms.stockprogramback.domain.stock.model;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Getter
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long stockId;
    private String name;
    private Integer highPrice;
    private Integer lowPrice;
    private Integer currentPrice;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    public void changeInfo(Integer price) {
        if(highPrice < price)
            highPrice = price;
        if(lowPrice > price)
            lowPrice = price;
        currentPrice = price;
    }
}
