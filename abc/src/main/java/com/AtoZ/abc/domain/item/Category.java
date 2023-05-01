package com.AtoZ.abc.domain.item;

import com.AtoZ.abc.dto.item.CategoryDto;
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

    @OneToMany(mappedBy = "category")
    private List<ItemCategory> itemCategories = new ArrayList<>();

    public void updateCategory(CategoryDto.CategoryUpdateDto categoryUpdateDto) {
        categoryName = categoryUpdateDto.getCategoryName();
    }
}
