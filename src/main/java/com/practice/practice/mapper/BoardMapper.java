package com.practice.practice.mapper;

import com.practice.practice.model.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {

    boolean insertBoard(Board board);

    List<Board> selectBoardList();
}
