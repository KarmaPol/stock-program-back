package com.pgms.stockprogramback.domain.memberStock.service;

import com.pgms.stockprogramback.domain.memberStock.repository.MemberStockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberStockService {

    private final MemberStockRepository memberStockRepository;
}
