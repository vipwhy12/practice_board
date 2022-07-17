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
        return boardMapper.insertBoard(board);
    }

    //게시판 조회
    public List<Board> selectBoardList(int limit, int offset) {
        return boardMapper.selectBoardList(limit, offset);
    }

    //게시판 상세 조회
    public Board selectBoardDetail(int no) {
        return boardMapper.selectBoardDetail(no);
    }

    //게시판 전체 개수 조회
    public int countBoard(){
        return boardMapper.countBoard();
    }

    //게시판 수정 조회
    public boolean updateBoard(Board board) {
        return boardMapper.updateBoard(board);
    }

    //게시판 삭제
    public boolean deleteBoard(int no){
        return boardMapper.deleteBoard(no);
    }

}


