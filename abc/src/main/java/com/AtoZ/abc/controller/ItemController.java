package com.AtoZ.abc.controller;


import com.AtoZ.abc.dto.ItemDto;
import com.AtoZ.abc.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/new")
    public ItemDto.ItemResponseDto createItem(@RequestBody ItemDto.ItemPostDto itemPostDto) {
        return itemService.saveItem(itemPostDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public ItemDto.ItemResponseDto findItem(@RequestParam Long itemId) {
        return itemService.findItem(itemId);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/edit")
    public ItemDto.ItemResponseDto updateItem(@RequestParam Long itemId, @RequestBody ItemDto.ItemUpdateDto itemUpdateDto) {
        return itemService.updateItem(itemId, itemUpdateDto);
    }
}
