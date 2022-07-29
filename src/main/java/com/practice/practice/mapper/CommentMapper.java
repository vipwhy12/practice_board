package com.practice.practice.mapper;

import com.practice.practice.model.Comment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {

    Comment selectComment(int boardNo);

}
