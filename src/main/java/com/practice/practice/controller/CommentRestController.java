package com.practice.practice.controller;

import com.practice.practice.model.Board;
import com.practice.practice.model.Comment;
import com.practice.practice.model.Member;
import com.practice.practice.service.CommentService;
import com.practice.practice.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentRestController {

    private final CommentService commentService;

    @PostMapping("/board/detail/{no}")
    public ResponseEntity<Comment> selectComment(@PathVariable("no") int no, Model model) {
        return commentService.selectComment(no);
    }

}

