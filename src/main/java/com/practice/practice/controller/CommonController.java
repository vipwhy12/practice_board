package com.practice.practice.controller;

import com.practice.practice.model.Member;
import com.practice.practice.service.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class CommonController {

    private final CommonService commonService;

    @GetMapping("/index")
    public String index(){
        return "index";
    }

}


