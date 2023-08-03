package com.douzon.smartlogistics.domain.member.api;

import com.douzon.smartlogistics.domain.entity.Member;
import com.douzon.smartlogistics.domain.member.application.MemberService;
import com.douzon.smartlogistics.domain.member.dto.LoginDto;
import com.douzon.smartlogistics.domain.member.interceptor.Auth;
import com.douzon.smartlogistics.global.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;


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
            session.setAttribute("session",member.getMemberNo());
        }
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(CommonResponse.successWith(member));
    }

    @PostMapping("/logout")
    public ResponseEntity<CommonResponse<String>> logout(HttpSession session) {
        session.removeAttribute("session");
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(CommonResponse.successWith(" Logout successful!!."));
    }

    @Auth
    @GetMapping("/list")
    public ResponseEntity<CommonResponse<List<Member>>> searchMemberList(
            @RequestParam(required = false) Integer memberNo,
            @RequestParam(required = false, defaultValue = "") String memberId,
            @RequestParam(required = false, defaultValue = "") String createDate) {

        List<Member> memberList = memberService.searchMemberList(memberNo, memberId, createDate);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(CommonResponse.successWith(memberList));
    }
    @Auth
    @PostMapping("/insert")
    public ResponseEntity<CommonResponse<Member>> insert(@RequestBody @Valid Member member) {
        memberService.insert(member);

        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(CommonResponse.successWith(member));
    }
    @Auth
    @PatchMapping("/modify")
    public ResponseEntity<CommonResponse<String>> modify(@RequestParam Integer memberNo,
                                                         @RequestBody @Valid Member member) {
    memberService.modify(memberNo, member);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(CommonResponse.successWithDefaultMessage());
    }
    @Auth
    @DeleteMapping("/delete")
    public ResponseEntity<CommonResponse<String>> delete(@RequestParam Integer memberNo) {
        memberService.delete(memberNo);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(CommonResponse.successWithDefaultMessage());
    }

}



