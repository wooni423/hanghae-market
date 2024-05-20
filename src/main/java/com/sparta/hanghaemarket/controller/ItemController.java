package com.sparta.hanghaemarket.controller;


import com.sparta.hanghaemarket.dto.ItemRequestDto;
import com.sparta.hanghaemarket.dto.ItemResponseDto;
import com.sparta.hanghaemarket.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class ItemController {

    private final ItemService itemService;
    
    // 판매 게시글 작성
    @PostMapping()
    public ItemResponseDto createItem(@RequestBody ItemRequestDto itemRequestDto){
        return itemService.createItem(itemRequestDto);
    }

    // 판매 게시글 전체 리스트 조회
    @GetMapping
    public List<ItemResponseDto> getItems(){
        return itemService.getItems();
    }

    // 판매 게시글 상세 조회
    @GetMapping("/{id}")
    public ItemResponseDto detailItem(@PathVariable Long id){
        return itemService.detailItem(id);
    }

    // 판매 게시글 상세 조회
    @PutMapping("/{id}")
    public ItemResponseDto updateItem(@PathVariable Long id,
                                      @RequestBody ItemRequestDto itemRequestDto){
        return itemService.updateItem(id,itemRequestDto);
    }
    
    // 판매 게시글 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeItem(@PathVariable Long id){
        itemService.removeItem(id);
        return ResponseEntity.ok().body(Map.of("msg","삭제완료"));
    }
    
}
