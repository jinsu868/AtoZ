package com.AtoZ.abc.repository.item;

import com.AtoZ.abc.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query(
            "select distinct i from Item i " +
                    "join fetch i.itemCategories ic " +
                    "join fetch ic.category c " +
                    "where c.id = :categoryId"
    )
    List<Item> findAllByCategoryId(Long categoryId);

}
