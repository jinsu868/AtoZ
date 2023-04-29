package com.AtoZ.abc.service;

import com.AtoZ.abc.domain.Item.Category;
import com.AtoZ.abc.domain.Item.Item;
import com.AtoZ.abc.domain.Item.ItemCategory;
import com.AtoZ.abc.domain.Item.Store;
import com.AtoZ.abc.dto.ItemDto;
import com.AtoZ.abc.mapper.ItemMapper;
import com.AtoZ.abc.repository.CategoryRepository;
import com.AtoZ.abc.repository.ItemRepository;
import com.AtoZ.abc.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemService {

    private final ItemRepository itemRepository;
    private final StoreRepository storeRepository;
    private final CategoryRepository categoryRepository;
    private final ItemMapper itemMapper;


    @Transactional
    public ItemDto.ItemResponseDto saveItem(ItemDto.ItemPostDto itemPostDto) {
        Item item = itemMapper.itemPostDtoToItem(itemPostDto);
        Store store = storeRepository.findById(itemPostDto.getStoreId()).orElseThrow();

        //Item - Store mapping
        item.setStore(store);

        //Item - Category mapping
        List<Category> categories = itemPostDto.getCategoryNames().stream()
                .map(m -> categoryRepository.findByCategoryName(m)).collect(Collectors.toList());

        for (Category category : categories) {
            ItemCategory itemCategory = ItemCategory.builder()
                    .item(item)
                    .category(category)
                    .build();

            item.getItemCategories().add(itemCategory);
            category.getItemCategories().add(itemCategory);
        }

        return itemMapper.itemToItemResponseDto(item);
    }
}
