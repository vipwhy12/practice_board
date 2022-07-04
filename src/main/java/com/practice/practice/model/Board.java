package com.practice.practice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    private int no;
    private String title;
    private String content;
    private Date time;
    private int view;
    private int memberNo;
    private Member member;
}
