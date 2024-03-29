package com.AtoZ.abc.controller.item;


import com.AtoZ.abc.dto.item.ItemDto;
import com.AtoZ.abc.service.item.ItemService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/allByCategory")
    public Result findItemsByCategory(@RequestParam Long categoryId) {
        List<ItemDto.ItemResponseDto> items = itemService.findAllByCategory(categoryId);
        return new Result(items);
        //return new ItemDto.Result(itemsService.findAllByCategory(categoryId));
    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private T data;
    }

}
