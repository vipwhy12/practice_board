package com.practice.practice.controller;

import com.practice.practice.model.Board;
import com.practice.practice.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
        return "/board/list";
    }

    //게시판 상세 페이지
    @GetMapping("board/{no}")
    public String detailBoard(@PathVariable("no") int no, Model model){
        Board boardDetail = boardService.selectBoardDetail(no);
        model.addAttribute("boardDetail", boardDetail);
        return "board/detail";
    }

    @GetMapping("boardUpdate/{no}")
    public String updateBoard(@PathVariable("no")int no, Model model){

        return "board/update";
    }

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
