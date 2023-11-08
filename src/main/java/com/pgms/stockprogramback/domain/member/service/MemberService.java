package com.pgms.stockprogramback.domain.member.service;

import com.pgms.stockprogramback.domain.member.model.Member;
import com.pgms.stockprogramback.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member getMember(Long id){
        return memberRepository.findById(id).orElseThrow(() -> new RuntimeException("존재하지 않는 멤버입니다."));
    }

    public void getMemberStockByMember(Long memberId){
        Member member = getMember(memberId);
//        member.getMemberStocks().stream().map(s -> )
    }
}
