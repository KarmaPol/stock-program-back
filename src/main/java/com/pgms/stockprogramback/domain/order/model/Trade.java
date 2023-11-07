package com.pgms.stockprogramback.domain.order.model;

import com.pgms.stockprogramback.domain.stock.model.Stock;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
public class Trade {
    @Id
    private Long id;
    private Integer price;
    private Integer quantity;
    private Boolean isTraded = false;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    private Stock stocks;

    public Integer getTotalPrice(){
        return price*quantity;
    }
}
