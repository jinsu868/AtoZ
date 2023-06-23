package com.AtoZ.abc.repository.item;

import com.AtoZ.abc.domain.item.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

    @Query(
            "select distinct s from Store s " +
                    "join fetch s.items si " +
                    "where s.id = :storeId"
    )
    Store findStoreWithItem(Long storeId);

    @Query(
            "select distinct s from Store s " +
                    "join fetch s.items si"
    )
    List<Store> findAllStoreWithItem();
}
