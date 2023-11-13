package com.pgms.stockprogramback.domain.stock.service;

import com.pgms.stockprogramback.domain.stock.dto.StockResponseDto;
import com.pgms.stockprogramback.domain.stock.mapper.StockMapper;
import com.pgms.stockprogramback.domain.stock.model.Stock;
import com.pgms.stockprogramback.domain.stock.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;
    private final StockMapper stockMapper;

    public Stock getStock(Long id){
        return stockRepository.findById(id).orElseThrow(() -> new RuntimeException("존재하지 않는 Stock입니다"));
    }

    public List<StockResponseDto> getStockList(){
        return stockRepository.findAll().stream().map(stockMapper::stockToStockResponseDto).toList();
    }
}
