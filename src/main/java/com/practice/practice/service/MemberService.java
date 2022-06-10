package com.practice.practice.service;

import com.practice.practice.mapper.MemberMapper;
import com.practice.practice.model.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberMapper memberMapper;

    public String insertMember(Member member) {
        log.info("insert member");
        boolean isSuccessful = memberMapper.insertMember(member);

        if (isSuccessful) {
            log.info("success");
            return "index";
        } else {
            log.error("error");
            return "error";
        }
    }

    public String selectMember(Member member){
        log.info("select member");
         Member memberInfo = memberMapper.selectMember(member);

        if (memberInfo != null) {
            log.info("success");
            return "index";
        } else {
            log.error("error");
            return "error";
        }

    }

}
