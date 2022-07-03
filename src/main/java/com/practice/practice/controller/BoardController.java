package com.practice.practice.controller;

import com.practice.practice.model.Board;
import com.practice.practice.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    //게시판 메인 페이지
    @GetMapping("/board/list")
    public String readBoard(){
        log.info("list page");
        return "/board/list";
    }

    //게시판 작성 페이지
    @GetMapping("/board/write")
    public String createBoard(){

        return  "/board/write";
    }

    @PostMapping("/board/write")
    public String createBoard(HttpServletResponse response, Board board, HttpSession session){
        board.setMemberNo((int)session.getAttribute("memberNo"));
        boardService.insertBoard(board);
        return "redirect:/board/list";
    }

}
