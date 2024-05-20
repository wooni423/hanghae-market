package com.sparta.hanghaemarket.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemRequestDto {

    // 작성자
    private String username;
    // 게시글 제목
    private String title;
    // 게시글 내용
    private String content;
    // 가격
    private int price;
}
