package com.AtoZ.abc.repository.item;

import com.AtoZ.abc.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
