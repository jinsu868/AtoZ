package com.AtoZ.abc.repository;

import com.AtoZ.abc.domain.Item.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
}
