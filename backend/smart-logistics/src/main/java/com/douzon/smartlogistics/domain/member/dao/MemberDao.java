package com.douzon.smartlogistics.domain.member.dao;

import com.douzon.smartlogistics.domain.entity.Member;
import com.douzon.smartlogistics.domain.member.dao.mapper.MemberMapper;
import com.douzon.smartlogistics.domain.member.dto.LoginDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MemberDao {
    private final MemberMapper memberMapper;
    public Member memberLogin(LoginDto logintDto) {
        return memberMapper.memberLogin(logintDto);
    }

    public boolean saveIpAddress(HashMap<String, Object> paramsMap) {
        return memberMapper.saveIpAddress(paramsMap);
    }
}
