package com.AtoZ.abc.controller;

import com.AtoZ.abc.dto.StoreDto;
import com.AtoZ.abc.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreController {

    private final StoreService storeService;

    //pass
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/new")
    public StoreDto.StoreResponseDto createStore(@RequestBody StoreDto.StorePostDto storePostDto) {
        return storeService.saveStore(storePostDto);
    }

    //pass
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public StoreDto.StoreResponseDto findStore(@RequestParam Long storeId) {
        return storeService.findStore(storeId);
    }

    //pass
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/edit")
    public StoreDto.StoreResponseDto updateStore(@RequestParam Long storeId, @RequestBody StoreDto.StoreUpdateDto storeUpdateDto) {
        return storeService.updateStore(storeId, storeUpdateDto);
    }
}
