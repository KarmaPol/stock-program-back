package com.pgms.stockprogramback.domain.member.model;

import com.pgms.stockprogramback.domain.memberStock.model.MemberStock;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
    private List<MemberStock> memberStocks = new ArrayList<>();
}
