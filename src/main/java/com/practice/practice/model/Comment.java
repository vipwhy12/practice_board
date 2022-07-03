package com.practice.practice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private int no;
    private String content;
    private Date time;
    private int member_no;
    private int board_no;
}
