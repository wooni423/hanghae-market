package com.sparta.hanghaemarket.entity;

import com.sparta.hanghaemarket.dto.ItemRequestDto;
import com.sparta.hanghaemarket.dto.ItemResponseDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "item")
@NoArgsConstructor
public class Item extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String username;

    // dto -> entity
    public Item(ItemRequestDto itemRequestDto){
        this.username = itemRequestDto.getUsername();
        this.title = itemRequestDto.getTitle();
        this.price = itemRequestDto.getPrice();
        this.content = itemRequestDto.getContent();
    }
    
    // 판매글 판매 메서드
    public void updateItem(ItemRequestDto itemRequestDto){
        this.username = itemRequestDto.getUsername();
        this.title = itemRequestDto.getTitle();
        this.price = itemRequestDto.getPrice();
        this.content = itemRequestDto.getContent();
    }
}
