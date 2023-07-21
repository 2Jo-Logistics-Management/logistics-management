package com.douzon.smartlogistics.domain.member.dao.mapper;

import com.douzon.smartlogistics.domain.entity.Member;
import com.douzon.smartlogistics.domain.member.dto.LoginDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    Member memberLogin(LoginDto logintDto);
}
