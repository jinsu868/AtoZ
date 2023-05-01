package com.AtoZ.abc.domain.item;

import com.AtoZ.abc.domain.BaseEntity;
import com.AtoZ.abc.dto.item.ItemDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Item extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<ItemCategory> itemCategories = new ArrayList<>();

    private int price;
    private int quantity;
    private String name;


    //연관관계 mapping method
    public void setStore(Store store) {
        this.store = store;
        store.getItems().add(this);
    }

    public void setItemCategories(List<ItemCategory> itemCategories) {
        this.itemCategories = itemCategories;
    }

    public void updateItem(ItemDto.ItemUpdateDto itemUpdateDto) {
        price = itemUpdateDto.getPrice();
        name = itemUpdateDto.getName();
        quantity = itemUpdateDto.getQuantity();
    }

    public void removeStock(int orderStock) {
        int result = quantity - orderStock;
        if (result >= 0) {
            quantity = result;
        }else {
            throw new RuntimeException();
        }
    }
}
