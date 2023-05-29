package com.AtoZ.abc.repository.order;

import com.AtoZ.abc.domain.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(
            "select distinct o from Order o" +
                    " join fetch o.delivery d" +
                    " join fetch o.user u" +
                    " where u.id = :userId")
    List<Order> findOrdersWithAll(Long userId);
}
