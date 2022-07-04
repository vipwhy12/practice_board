package com.practice.practice.service;

import com.practice.practice.mapper.MemberMapper;
import com.practice.practice.model.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberMapper memberMapper;

    //insert Member
    public boolean insertMember(Member member) {
        log.info("insert member");
        return memberMapper.insertMember(member);
    }

    //restAPI(회원조회)
    public ResponseEntity<Member> selectMember(Member member, HttpSession session){
        log.info("select member");
        Member memberInfo = memberMapper.selectMember(member);

        if (memberInfo != null) {
            //log 확인
            log.info("success");

            //세션 값 설정
            System.out.println("MemberService 테스트" + memberInfo);
            session.setAttribute("memberNo", memberInfo.getNo());
            session.setAttribute("memberName", memberInfo.getName());

            //세션 유지시간 설정(초단위)
            session.setMaxInactiveInterval(30*60);
            System.out.println(session.getAttribute("memberNo"));
            return ResponseEntity.ok().body(memberInfo);
        } else {
            log.error("error");
            return ResponseEntity.badRequest().body(member);
        }

    }

}
