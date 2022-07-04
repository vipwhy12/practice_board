package com.practice.practice.controller;

import com.practice.practice.model.Board;
import com.practice.practice.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

@Slf4j
@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    //게시판 list 페이지
    @GetMapping("/board/list")
    public String readBoard(Model model){
        List<Board> boardList = boardService.selectBoardList();
        model.addAttribute("boardList", boardList);
        System.out.println(boardList);
        return "/board/list";
    }

    //게시판 상세 페이지
   // @GetMapping("board/{no}")
   // public String detailBoard(@PathVariable("no") Board no){
    //    return "board/detail";
    //}

    //게시판 작성 페이지
    @GetMapping("/board/write")
    public String createBoard(){
        return  "/board/write";
    }

    @PostMapping("/board/write")
    public String createBoard(HttpServletResponse response, HttpSession session, Board board){

        boolean inSuccessful = boardService.insertBoard(board);
        board.setMemberNo((int)session.getAttribute("memberNo"));
        if (inSuccessful) {
            log.info("success");
            return "redirect:/board/list";
        } else {
            log.error("error");
            return "error";
        }

    }
}
