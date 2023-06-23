package com.AtoZ.abc.controller.item;

import com.AtoZ.abc.dto.item.StoreDto;
import com.AtoZ.abc.service.item.StoreService;
import com.sun.net.httpserver.HttpsServer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all")
    public List<StoreDto.StoreResponseDto> findStores() {
        return storeService.findStores();
    }

    //pass
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/edit")
    public StoreDto.StoreResponseDto updateStore(@RequestParam Long storeId, @RequestBody StoreDto.StoreUpdateDto storeUpdateDto) {
        return storeService.updateStore(storeId, storeUpdateDto);
    }
}
