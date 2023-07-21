package com.douzon.smartlogistics.domain.member.api;

import com.douzon.smartlogistics.domain.entity.Member;
import com.douzon.smartlogistics.domain.member.application.MemberService;
import com.douzon.smartlogistics.domain.member.dto.LoginDto;
import com.douzon.smartlogistics.global.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/login")
    public ResponseEntity<CommonResponse<Member>> login(@RequestBody LoginDto logintDto, HttpSession session) {
        Member member = memberService.memberLogin(logintDto);
        if(member != null) {
            session.setAttribute("sessionNo",member.getMemberNo());

        }
        return ResponseEntity.ok()
                             .contentType(MediaType.APPLICATION_JSON)
                             .body(CommonResponse.successWith(member));
    }
}
