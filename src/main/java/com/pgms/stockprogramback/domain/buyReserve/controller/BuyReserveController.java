package com.pgms.stockprogramback.domain.buyReserve.controller;

import com.pgms.stockprogramback.domain.buyReserve.dto.BuyReserveRequestDto;
import com.pgms.stockprogramback.domain.buyReserve.dto.BuyReserveResponseDto;
import com.pgms.stockprogramback.domain.buyReserve.service.BuyReserveService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BuyReserveController {

    private final BuyReserveService buyReserveService;

    @GetMapping("/reserves/{memberId}/buy")
    public List<BuyReserveResponseDto> getBuyReserveList(@PathVariable Long memberId){
        return buyReserveService.getBuyReserveListByMember(memberId);
    }

    @PostMapping("/reserves/{memberId}/buy")
    public void postBuyReserve(@PathVariable Long memberId, @ModelAttribute BuyReserveRequestDto buyReserveRequestDto){
        buyReserveService.postBuyReserve(buyReserveRequestDto);
    }
}
