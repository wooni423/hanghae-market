package com.sparta.hanghaemarket.dto;

import com.sparta.hanghaemarket.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemResponseDto {

    // 게시글 번호
    private Long id;

    // 게시글 제목
    private String username;

    // 게시글 내용
    private String content;

    // 가격
    private int price;

    public ItemResponseDto(Item item) {
        this.id = item.getId();
        this.username = item.getUsername();
        this.content = item.getContent();
        this.price = item.getPrice();
    }
}
