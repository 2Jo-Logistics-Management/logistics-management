package com.douzon.smartlogistics.domain.entity;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
@Getter
public class Member {
    private final int memberNo;
    private final String memberId;
    private final String memberRole;
    private final Date createDate;
    private final String ipaddress;
}
