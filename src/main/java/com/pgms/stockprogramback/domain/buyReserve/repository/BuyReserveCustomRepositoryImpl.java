package com.pgms.stockprogramback.domain.buyReserve.repository;

import com.pgms.stockprogramback.domain.buyReserve.model.BuyReserve;
import com.pgms.stockprogramback.domain.stock.model.Stock;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.pgms.stockprogramback.domain.buyReserve.model.QBuyReserve.buyReserve;

@Repository
@RequiredArgsConstructor
@Slf4j
public class BuyReserveCustomRepositoryImpl implements BuyReserveCustomRepository{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<BuyReserve> findBuyReserveByStockAndPrice(Stock stock, Integer price, Integer quantity) {
        log.info(">>>> query");
        return Optional.ofNullable(jpaQueryFactory.selectFrom(buyReserve)
                .where(buyReserve.stock.eq(stock)
//                        buyReserve.price.goe(price),
//                        buyReserve.quantity.loe(quantity)
                )
                .fetchFirst());
    }
}
