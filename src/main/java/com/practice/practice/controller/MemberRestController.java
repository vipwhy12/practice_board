package com.practice.practice.controller;

import com.practice.practice.model.Member;
import com.practice.practice.service.MemberService;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.net.ssl.HandshakeCompletedEvent;
import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
public class MemberRestController {

    private final MemberService memberService;


    @PostMapping(value = "/login")
    public ResponseEntity<Member> findMemberWithResponseEntity(@Nullable Member body, HttpSession session){
        // if success add session
        // else return badRequest
        return memberService.selectMember(body, session);
    }


}
