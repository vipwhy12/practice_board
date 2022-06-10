package com.practice.practice.controller;

import com.practice.practice.mapper.MemberMapper;
import com.practice.practice.model.Member;
import com.practice.practice.service.CommonService;
import com.practice.practice.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.metal.MetalMenuBarUI;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    //join 페이지
    @GetMapping("/join")
    public String join(){
        return "join";
    }

    @PostMapping("/join")
    public String join(HttpServletResponse response, Member member) {
        System.out.println(member);
        return memberService.insertMember(member);
    }

    //login 페이지
    @GetMapping("/login")
    public String login() { return "login"; }

    @PostMapping("/login")
    public String login(HttpServletResponse response, Member member){
        System.out.println("로그인1"+ member);
        return memberService.selectMember(member);
    }
}
