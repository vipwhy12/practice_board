package com.practice.practice.controller;

import com.practice.practice.model.Board;
import com.practice.practice.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String readBoard(Model model, @RequestParam(value = "page", required = false, defaultValue = "1") String page){
        int totalPage = 1;

        final int LIMIT = 10;
        int totalBoardNum = boardService.countBoard();
        int offset = (Integer.parseInt(page) - 1) * LIMIT;

        if(totalBoardNum >= LIMIT && totalBoardNum % LIMIT != 0){
            totalPage = totalBoardNum / LIMIT + 1 ;
        }

        List<Board> boardList = boardService.selectBoardList(LIMIT,offset);
        model.addAttribute("boardList", boardList);
        model.addAttribute("offset", offset);
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("page", page);
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
        return  "/board/update";
    }

    @PostMapping("board/update")
    public String updateBoard(HttpSession session, Board board){
        boolean isSuccessful = boardService.updateBoard(board);

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
    public String insertBoard(HttpSession session, Board board, Model model){
        //게시판 객체에 세션에 저장되어 있는 회원 번호를 설정
        board.setMemberNo((int)session.getAttribute("memberNo"));
        boolean isSuccessful = boardService.insertBoard(board);
        model.addAttribute("insert", isSuccessful);
        log.info("insert board");
        if (isSuccessful) {
            log.info("success");
            return "redirect:/board/list";
        } else {
            log.error("error");
            return "error";
        }
    }

    @GetMapping("/board/delete/{no}")
    public String deleteBoard(@PathVariable("no")int no, Model model){
        boolean isSuccessful = boardService.deleteBoard(no);
        log.info("insert board");
        if (isSuccessful) {
            log.info("success");
            return "redirect:/board/list";
        } else {
            log.error("error");
            return "error";
        }
    }

}
