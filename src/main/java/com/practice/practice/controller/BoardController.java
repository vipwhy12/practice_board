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
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    //게시판 메인 페이지
    @GetMapping("/board/list")
    public String readBoard(Model model, HttpSession session){
        model.addAttribute("id", session);
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

    //게시판 작성 수정 페이지
    @GetMapping("/board/update/{no}")
    public String updateBoard(@PathVariable("no")int no, Model model){
        Board boardUpdate = boardService.selectBoardDetail(no);
        model.addAttribute("boardUpdate", boardUpdate);
        System.out.println("update페이지 잘 실행했습니다!");
        return  "/board/update";
    }

    @PostMapping("board/update")
    public String updateBoard(HttpSession session, Board board){
        board.setMemberNo((int)session.getAttribute("memberNo"));
        System.out.println("boardUpdateTest1"+board);

        boolean isSuccessful = boardService.updateBoard(board);
        System.out.println("boardUpdateTest2"+board);

        if(isSuccessful){
            log.info("success");
            return "redirect:/board/list";
        }else {
            log.error("error");
            return "error";
        }
    }

    //게시판 입력
    @GetMapping("/board/write")
    public String insertBoard(){
        return "/board/write";
    }

    @PostMapping("/board/write")
    public String insertBoard(HttpSession session, Board board){
        //게시판 객체에 세션에 저장되어 있는 회원 번호를 설정
        board.setMemberNo((int)session.getAttribute("memberNo"));
        boolean isSuccessful = boardService.insertBoard(board);
        log.info("insert board");
        if (isSuccessful) {
            log.info("success");
            return "redirect:/board/list";
        } else {
            log.error("error");
            return "error";
        }

    }

    //게시판 삭제 페이지
    @GetMapping("board/delete/{no}")
    public String deleteBoard(){

        return "/redirect:/";
    }
}
