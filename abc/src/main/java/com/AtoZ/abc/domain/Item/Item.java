package com.AtoZ.abc.domain.Item;

import com.AtoZ.abc.domain.BaseEntity;
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

    @OneToMany(mappedBy = "item")
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
}
