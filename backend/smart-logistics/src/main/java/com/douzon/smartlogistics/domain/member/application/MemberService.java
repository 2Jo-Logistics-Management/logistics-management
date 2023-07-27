package com.douzon.smartlogistics.domain.member.application;

import com.douzon.smartlogistics.domain.entity.Member;
import com.douzon.smartlogistics.domain.member.dao.MemberDao;
import com.douzon.smartlogistics.domain.member.dto.LoginDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberDao memberDao;
    public Member memberLogin(LoginDto logintDto) {
        return memberDao.memberLogin(logintDto);
    }


    public boolean saveIpAddress(HashMap<String, Object> paramsMap) {
        return memberDao.saveIpAddress(paramsMap);
    }
}
