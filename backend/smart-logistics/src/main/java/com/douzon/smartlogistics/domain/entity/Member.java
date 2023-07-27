package com.douzon.smartlogistics.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;


import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private int memberNo;
    private String memberId;
    private String password;
    private String memberRole;
    private Date createDate;
    private String ipaddress;
}
