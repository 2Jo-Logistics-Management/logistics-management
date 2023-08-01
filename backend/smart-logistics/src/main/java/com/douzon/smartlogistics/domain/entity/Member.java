package com.douzon.smartlogistics.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Date;

@RequiredArgsConstructor
@Getter
@ToString
public class Member {
    private final Long memberNo;
    private final String memberName;
    private final String memberId;
    private final String password;
    private final String memberRole;
    private final Date createDate;
    private final String ipaddress;
}
