package com.practice.practice.service;

import com.practice.practice.mapper.CommentMapper;
import com.practice.practice.model.Comment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.net.ConnectException;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentMapper commentMapper;

    public ResponseEntity<Comment> selectComment(int boardNo){
        log.info("select Comment");

        Comment comment = commentMapper.selectComment(boardNo);

        if (comment != null){
            log.info("success");
            return ResponseEntity.ok().body(comment);
        }else {
            log.error("error");
            return ResponseEntity.badRequest().body(comment);
        }

    }


}
