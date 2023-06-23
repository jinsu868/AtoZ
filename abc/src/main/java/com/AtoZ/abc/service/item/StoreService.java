package com.AtoZ.abc.service.item;

import com.AtoZ.abc.domain.item.Store;
import com.AtoZ.abc.dto.item.StoreDto;
import com.AtoZ.abc.mapper.item.StoreMapper;
import com.AtoZ.abc.repository.item.StoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

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
        Store store = storeRepository.findStoreWithItem(id);
        return storeMapper.storeToStoreResponseDto(store);
    }

    @Transactional
    public StoreDto.StoreResponseDto updateStore(Long storeId, StoreDto.StoreUpdateDto storeUpdateDto) {
        Store store = storeRepository.findById(storeId).orElseThrow();
        store.updateStore(storeUpdateDto);
        return storeMapper.storeToStoreResponseDto(store);
    }


    public List<StoreDto.StoreResponseDto> findStores() {
        return storeRepository.findAllStoreWithItem()
                .stream().map(s -> storeMapper.storeToStoreResponseDto(s))
                .collect(Collectors.toList());
    }
}
