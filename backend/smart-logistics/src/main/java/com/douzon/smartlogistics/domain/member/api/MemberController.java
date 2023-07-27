package com.douzon.smartlogistics.domain.member.api;

import com.douzon.smartlogistics.domain.entity.Member;
import com.douzon.smartlogistics.domain.member.application.MemberService;
import com.douzon.smartlogistics.domain.member.dto.LoginDto;
import com.douzon.smartlogistics.global.common.response.CommonResponse;
import com.douzon.smartlogistics.global.common.response.ErrorResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;
    private final HttpServletRequest request;

    @PostMapping("/login")
    public ResponseEntity<CommonResponse<Member>> login(@RequestBody LoginDto logintDto, HttpSession session) throws UnknownHostException {

        Member member = memberService.memberLogin(logintDto);
        if(member != null) {
            HashMap<String, Object> paramsMap = new HashMap<String, Object>();
            try {
                InetAddress localhost = InetAddress.getLocalHost();
                String ipAddress = localhost.getHostAddress();
                paramsMap.put("ipAddress", ipAddress);
                paramsMap.put("memberNo", member.getMemberNo());
            } catch (UnknownHostException e)

            {
                e.printStackTrace();


            }

            memberService.saveIpAddress(paramsMap);
            session.setAttribute("sessionNo",member.getMemberNo());
        }
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(CommonResponse.successWith(member));
    }

}



