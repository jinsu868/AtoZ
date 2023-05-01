package com.AtoZ.abc.repository.item;

import com.AtoZ.abc.domain.item.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
}
