package com.AtoZ.abc.domain.order;

import com.AtoZ.abc.domain.BaseEntity;
import com.AtoZ.abc.domain.item.Item;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    private int quantity;
    private int price;
    private String name;

    public static OrderItem createOrderItem(Item item, Order order, int orderQuantity) {
        OrderItem orderItem = OrderItem.builder()
                .item(item)
                .order(order)
                .quantity(orderQuantity)
                .price(item.getPrice())
                .name(item.getName())
                .build();

        item.removeStock(orderQuantity);
        return orderItem;
    }
}
