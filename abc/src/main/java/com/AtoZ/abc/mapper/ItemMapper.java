package com.AtoZ.abc.mapper;

import com.AtoZ.abc.domain.Item.Item;
import com.AtoZ.abc.domain.Item.ItemCategory;
import com.AtoZ.abc.dto.ItemDto;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    default Item itemPostDtoToItem(ItemDto.ItemPostDto itemPostDto) {
        return Item.builder()
                .name(itemPostDto.getName())
                .price(itemPostDto.getPrice())
                .quantity(itemPostDto.getQuantity())
                .itemCategories(new ArrayList<>())
                .build();
    }

    default ItemDto.ItemResponseDto itemToItemResponseDto(Item item) {
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
