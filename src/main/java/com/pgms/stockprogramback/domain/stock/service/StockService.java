package com.pgms.stockprogramback.domain.stock.service;

import com.pgms.stockprogramback.domain.stock.model.Stock;
import com.pgms.stockprogramback.domain.stock.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;

    public Stock getStock(Long id){
        return stockRepository.findById(id).orElseThrow(() -> new RuntimeException("존재하지 않는 Stock입니다"));
    }
}
