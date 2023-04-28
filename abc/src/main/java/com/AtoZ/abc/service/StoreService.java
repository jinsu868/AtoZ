package com.AtoZ.abc.service;

import com.AtoZ.abc.domain.Item.Store;
import com.AtoZ.abc.dto.StoreDto;
import com.AtoZ.abc.mapper.StoreMapper;
import com.AtoZ.abc.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreService {

    private final StoreRepository storeRepository;
    private final StoreMapper storeMapper;

    public StoreDto.StoreResponseDto saveStore(StoreDto.StorePostDto storePostDto) {
        Store store = storeMapper.storePostDtoToStore(storePostDto);
        return storeMapper.storeToStoreResponseDto(storeRepository.save(store));
    }
    
}
