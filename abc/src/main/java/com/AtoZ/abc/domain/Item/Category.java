package com.AtoZ.abc.domain.Item;

import com.AtoZ.abc.domain.Item.ItemCategory;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "category")
    private List<ItemCategory> itemCategories = new ArrayList<>();

}
