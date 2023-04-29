package com.AtoZ.abc.domain.Item;

import com.AtoZ.abc.domain.Item.ItemCategory;
import com.AtoZ.abc.dto.CategoryDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String categoryName;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<ItemCategory> itemCategories = new ArrayList<>();

    public void updateCategory(CategoryDto.CategoryUpdateDto categoryUpdateDto) {
        categoryName = categoryUpdateDto.getCategoryName();
    }
}
