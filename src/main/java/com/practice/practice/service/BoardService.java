package com.practice.practice.service;

import com.practice.practice.mapper.BoardMapper;
import com.practice.practice.model.Board;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper boardMapper;

    public String insertBoard(Board board) {
        log.info("insert board");
        boolean inSuccessful = boardMapper.insertBoard(board);

        if (inSuccessful) {
            log.info("success");
            return "board/list";
        } else {
            log.error("error");
            return "error";
        }
    }
}