package com.practice.practice.controller;

import com.practice.practice.mapper.MemberMapper;
import com.practice.practice.model.Member;
import com.practice.practice.service.CommonService;
import com.practice.practice.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.metal.MetalMenuBarUI;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    //회원가입 페이지
    @GetMapping("/join")
    public String join(){
        return "join";
    }

    @PostMapping("/join")
    public String join(HttpServletResponse response, Member member) {
        System.out.println(member);

        boolean isSuccessful = memberService.insertMember(member);

        if (isSuccessful) {
            log.info("success");
            return "redirect:/login";
        } else {
            log.error("error");
            return "error";
        }
    }

    //로그인 페이지
    @GetMapping("/login")
    public String login() { return "login"; }

  /*
    @PostMapping("/login")
    public String login(HttpServletResponse response, Member member){
        System.out.println("로그인1"+ member);
        return memberService.selectMember(member);
    }
    */
}
