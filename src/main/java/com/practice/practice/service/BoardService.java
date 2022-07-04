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

    //게시판 작성
    public boolean insertBoard(Board board) {
        log.info("insert board");
        return boardMapper.insertBoard(board);
    }

    //게시판 조회
    public List<Board> selectBoardList(){
        return boardMapper.selectBoardList();
    }


    public Board selectBoardDetail(int no){
        return boardMapper.selectBoardDetail(no);
    }

}