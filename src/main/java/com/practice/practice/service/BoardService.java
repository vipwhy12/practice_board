package com.practice.practice.service;

import com.practice.practice.mapper.BoardMapper;
import com.practice.practice.model.Board;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper boardMapper;

    public boolean insertBoard(Board board) {
        log.info("insert board");
        return boardMapper.insertBoard(board);
    }

    public List<Board> selectBoardList(){
        return boardMapper.selectBoardList();
    }

}