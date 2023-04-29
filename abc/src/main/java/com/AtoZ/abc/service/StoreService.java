package com.AtoZ.abc.service;

import com.AtoZ.abc.domain.Item.Store;
import com.AtoZ.abc.dto.StoreDto;
import com.AtoZ.abc.mapper.StoreMapper;
import com.AtoZ.abc.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreService {

    private final StoreRepository storeRepository;
    private final StoreMapper storeMapper;

    @Transactional
    public StoreDto.StoreResponseDto saveStore(@RequestBody StoreDto.StorePostDto storePostDto) {
        Store store = storeMapper.storePostDtoToStore(storePostDto);
        return storeMapper.storeToStoreResponseDto(storeRepository.save(store));
    }

    public StoreDto.StoreResponseDto findStore(Long id) {
        Store store = storeRepository.findById(id).orElseThrow();
        return storeMapper.storeToStoreResponseDto(store);
    }

    @Transactional
    public StoreDto.StoreResponseDto updateStore(Long storeId, StoreDto.StoreUpdateDto storeUpdateDto) {
        Store store = storeRepository.findById(storeId).orElseThrow();
        store.updateStore(storeUpdateDto);
        return storeMapper.storeToStoreResponseDto(store);
    }


}
