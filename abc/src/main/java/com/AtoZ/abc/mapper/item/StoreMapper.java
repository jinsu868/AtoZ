package com.AtoZ.abc.mapper.item;

import com.AtoZ.abc.domain.item.Item;
import com.AtoZ.abc.domain.item.ItemCategory;
import com.AtoZ.abc.domain.item.Store;
import com.AtoZ.abc.dto.item.ItemDto;
import com.AtoZ.abc.dto.item.StoreDto;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface StoreMapper {

    default Store storePostDtoToStore(StoreDto.StorePostDto storePostDto) {
        return Store.builder()
                .items(new ArrayList<>())
                .name(storePostDto.getStoreName())
                .build();
    }

    default StoreDto.StoreResponseDto storeToStoreResponseDto(Store store) {
        return StoreDto.StoreResponseDto.builder()
                .storeName(store.getName())
                .itemResponseDtos(store.getItems().stream().map(m -> itemToItemResponseDtoAtStore(m)).collect(Collectors.toList()))
                .build();
    }

    //필요없음.
    default ItemDto.ItemResponseDto itemToItemResponseDtoAtStore(Item item) {
        return ItemDto.ItemResponseDto.builder()
                .name(item.getName())
                .price(item.getPrice())
                .quantity(item.getQuantity())
                .categoryNames(getCategoryNames(item))
                .build();
    }

    default List<String> getCategoryNames(Item item) {
        List<ItemCategory> itemCategories = item.getItemCategories();
        List<String> categoryNames = new ArrayList<>();

        for (ItemCategory itemCategory : itemCategories) {
            categoryNames.add(itemCategory.getCategory().getCategoryName());
        }

        return categoryNames;
    }
}
