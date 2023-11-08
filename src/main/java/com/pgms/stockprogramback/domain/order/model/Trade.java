package com.pgms.stockprogramback.domain.order.model;

import com.pgms.stockprogramback.domain.stock.model.Stock;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Entity
public class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer price;
    private Integer quantity;
    private Boolean isTraded = false;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;
    @OneToOne(fetch = FetchType.LAZY)
    private Stock stock;

    public Trade() {}

    public void sellStock(Integer quantity){
        this.quantity -= quantity;
        if(quantity == 0)
            isTraded = true;
    }
}
