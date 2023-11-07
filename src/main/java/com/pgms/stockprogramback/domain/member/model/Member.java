package com.pgms.stockprogramback.domain.member.model;

import com.pgms.stockprogramback.domain.memberStock.model.MemberStock;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member {
    @Id
    private Long id;
    @OneToMany(mappedBy = "member")
    private List<MemberStock> memberStocks = new ArrayList<>();
}
