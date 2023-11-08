package com.pgms.stockprogramback.domain.buyReserve.repository;

import com.pgms.stockprogramback.domain.buyReserve.model.BuyReserve;
import com.pgms.stockprogramback.domain.stock.model.Stock;

import java.util.Optional;

public interface BuyReserveCustomRepository {

    Optional<BuyReserve> findBuyReserveByStockAndPrice(Stock stock, Integer price, Integer quantity);
}
