package com.douzon.smartlogistics.domain.entity;

import lombok.Data;
import java.util.Date;

@Data
public class Member {
    private int memberNo;
    private String memberId;
    private String memberRole;
    private Date createDate;
    private String ipaddress;
}
