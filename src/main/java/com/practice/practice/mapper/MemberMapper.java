package com.practice.practice.mapper;

import com.practice.practice.model.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    Member selectMember(Member member);
    boolean insertMember(Member member);

}
