package com.pgms.stockprogramback.domain.member.service;

import com.pgms.stockprogramback.domain.member.model.Member;
import com.pgms.stockprogramback.domain.member.repository.MemberRepository;
import com.pgms.stockprogramback.domain.memberStock.dto.MemberStockResponseDto;
import com.pgms.stockprogramback.domain.memberStock.mapper.MemberStockMapper;
import com.pgms.stockprogramback.domain.stock.mapper.StockMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberStockMapper memberStockMapper;
    private final StockMapper stockMapper;

    public Member getMember(Long id){
        return memberRepository.findById(id).orElseThrow(() -> new RuntimeException("존재하지 않는 멤버입니다."));
    }

    public List<MemberStockResponseDto> getMemberStocksByMember(Long memberId){
        Member member = getMember(memberId);
        return member.getMemberStocks().stream()
                .map(s -> memberStockMapper.memberStockToMemberStockResponseDto(s, stockMapper.stockToStockResponseDto(s.getStock()))).toList();
    }
}
