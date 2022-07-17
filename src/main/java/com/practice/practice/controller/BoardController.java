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
import org.springframework.web.bind.annotation.RequestParam;

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
    public String readBoard( Model model, HttpSession session){
        int totalBoardCount = boardService.countBoard();
        int pageNum = 10;
        int offset = 0;
        int limit = 0;
        int totalPageOfNum = totalBoardCount / pageNum;

        if(totalBoardCount <= 10){
            totalPageOfNum = 1;
            limit = totalBoardCount;
        }else {
            if (totalBoardCount % pageNum != 0){
                totalPageOfNum += 1;
                limit = 10;
            }
        }
        //세션에 회원 아이디 저장
        model.addAttribute("id", session);
        model.addAttribute("totalPageOfNum", totalPageOfNum);
        model.addAttribute("offset",offset);
        model.addAttribute("limit",limit);

        //게시판 리스트 불러오기, 모델에 저장
        List<Board> boardList = boardService.selectBoardList(limit,offset);
        model.addAttribute("boardList", boardList);
        return "/board/list";
    }

    @GetMapping("/board/list/page")
    public String readBoard(@RequestParam int page, @RequestParam int totalPageOfNum, Model model, HttpSession session){
        int offset = (page - 1) * 10;
        int limit = page * 10;
        List<Board> boardList = boardService.selectBoardList(limit,offset);
        model.addAttribute("boardList", boardList);
        model.addAttribute("totalPageOfNum", totalPageOfNum);
        model.addAttribute("offset",offset);
        model.addAttribute("limit",limit);
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
