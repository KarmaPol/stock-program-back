package com.pgms.stockprogramback.domain.member.controller;

import com.pgms.stockprogramback.domain.member.service.MemberService;
import com.pgms.stockprogramback.domain.memberStock.dto.MemberStockResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members/{memberId}/stocks")
    public List<MemberStockResponseDto> getMemberStockList(@PathVariable Long memberId){
        return memberService.getMemberStocksByMember(memberId);
    }
}
