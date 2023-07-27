package com.douzon.smartlogistics.domain.member.api;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/member")
public class MemberController {

    @RequestMapping("test")
    public String test1(HttpSession session) {

        session.setAttribute("email","test");

        return "test";
    }
}
