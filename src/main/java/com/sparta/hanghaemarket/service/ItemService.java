package com.sparta.hanghaemarket.service;

import com.sparta.hanghaemarket.dto.ItemRequestDto;
import com.sparta.hanghaemarket.dto.ItemResponseDto;
import com.sparta.hanghaemarket.entity.Item;
import com.sparta.hanghaemarket.repository.ItemRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    // 상품 판매 게시글 등록
    @Transactional
    public ItemResponseDto createItem(ItemRequestDto itemRequestDto) {
        Item item = itemRepository.save(new Item(itemRequestDto));
        return new ItemResponseDto(item);
    }

    // 판매 게시글 전체 리스트 조회
    @Transactional
    public List<ItemResponseDto> getItems() {
        List<Item> itemList = itemRepository.findAll();
        List<ItemResponseDto> responseDtoList = new ArrayList<>();

        for(Item item : itemList){
            responseDtoList.add(new ItemResponseDto(item));
        }

        return responseDtoList;
    }

    // 판매 게시글 상세 조회
    @Transactional
    public ItemResponseDto detailItem(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("해당 상품을 찾지 못했습니다."));

        return  new ItemResponseDto(item);
    }

    // 판매 게시글 수정
    public ItemResponseDto updateItem(Long id,ItemRequestDto itemRequestDto) {

        // 해당 상품이 존재 하는지 확인
        Item item = itemRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("해당 상품을 찾지 못했습니다."));
        
        // 판매 게시글 업데이트 및 DB 저장
        item.updateItem(itemRequestDto);
        itemRepository.save(item);

        return new ItemResponseDto(item);
    }
    
    // 판매 게시글 삭제
    @Transactional
    public void removeItem(Long id) {

        // 해당 상품이 존재 하는지 확인
        Item item = itemRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("해당 상품을 찾지 못했습니다."));

        itemRepository.delete(item);
    }
}
