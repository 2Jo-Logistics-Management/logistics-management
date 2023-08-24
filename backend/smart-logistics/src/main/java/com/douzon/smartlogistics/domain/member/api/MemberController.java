package com.douzon.smartlogistics.domain.member.api;

import com.douzon.smartlogistics.domain.entity.Member;
import com.douzon.smartlogistics.domain.member.application.MemberService;
import com.douzon.smartlogistics.domain.member.dto.LoginDto;
import com.douzon.smartlogistics.global.common.exception.auth.Auth;
import com.douzon.smartlogistics.global.common.response.CommonResponse;
import com.douzon.smartlogistics.global.common.response.ErrorResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
@Api(tags = "회원관리 API 명세서")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;
    private final HttpServletRequest request;

    @Operation(summary = "로그인",
            description = "로그인 요청을 처리하고 데이터 베이스를 조회해 결과를 반환합니다.",
            responses = {@ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json", schema =
                    @Schema(implementation = CommonResponse.class)))})
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

                memberService.saveIpAddress(paramsMap);
                session.setAttribute("session",member.getMemberNo());

                return ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(CommonResponse.successWith(member));
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }

        }
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(CommonResponse.error(new ErrorResponse("로그인에 실패하였습니다.")));
    }

    @Operation(summary = "로그아웃",
            description = "로그아웃 요청을 처리하고 데이터 베이스를 조회해 결과를 반환합니다.",
            responses = {@ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json", schema =
                    @Schema(implementation = CommonResponse.class)))})
    @PostMapping("/logout")
    public ResponseEntity<CommonResponse<String>> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(CommonResponse.successWith(" Logout successful!!."));
    }


    @Operation(summary = "멤버 리스트 조회",
            description = "멤버 리스트 조회 요청을 처리하고 데이터 베이스를 조회해 리스트로 결과를 반환합니다.",
            responses = {@ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json", schema =
                    @Schema(implementation = CommonResponse.class)))})
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
    @Operation(summary = "멤버 등록",
            description = "멤버 등록에 알맞은 데이터를 받아 데이터베이스에 삽입합니다.",
            responses = @ApiResponse(responseCode = "201", content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = CommonResponse.class))))
    @PostMapping("/insert")
    public ResponseEntity<CommonResponse<Member>> insert(@RequestBody @Valid Member member) {
        memberService.insert(member);

        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(CommonResponse.successWith(member));
    }
    @Auth
    @Operation(summary = "멤버 수정",
            description = "멤버 수정에 알맞은 데이터를 받아 데이터베이스의 데이터를 수정합니다.",
            responses = @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CommonResponse.class))))
    @PatchMapping("/modify")
    public ResponseEntity<CommonResponse<String>> modify(@RequestParam Integer memberNo,
                                                         @RequestBody @Valid Member member) {
    memberService.modify(memberNo, member);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(CommonResponse.successWithDefaultMessage());
    }
    @Auth
    @Operation(summary = "멤버 삭제",
            description = "멤버 삭제에 알맞은 데이터를 받아 데이터베이스의 데이터를 삭제합니다.",
            responses = {@ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json", schema =
                    @Schema(implementation = CommonResponse.class)))})
    @DeleteMapping("/delete")
    public ResponseEntity<CommonResponse<String>> delete(@RequestBody List<Integer> memberNos) {
        memberService.delete(memberNos);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(CommonResponse.successWithDefaultMessage());
    }

}



