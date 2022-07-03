package com.practice.practice.mapper;

import com.practice.practice.model.Board;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
    boolean insertBoard(Board board);
}
