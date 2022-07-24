package com.practice.practice.mapper;

import com.practice.practice.model.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {


    //게시판 입력
    boolean insertBoard(Board board);

    //게시판 리스트 출력
    List<Board> selectBoardList(int limit, int offset);

    //게시판 상세보기 출력
    Board selectBoardDetail(int no);

    //게시판 개수 출력
    int countBoard();

    //게시판 수정
    boolean updateBoard(Board board);

    //게시판 삭제
    boolean deleteBoard(int no);


}
