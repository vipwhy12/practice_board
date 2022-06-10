package com.practice.practice.service;

import com.practice.practice.mapper.CommonMapper;
import com.practice.practice.model.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommonService {
    /*
    private final CommonMapper commonMapper;

    public void insertMember(Member member) {
        log.info("insert member");
        boolean isSuccessful = commonMapper.insertMember(member);

        if (isSuccessful) {
            log.info("success");
        } else {
            log.error("error");
        }
    }

     */
}
