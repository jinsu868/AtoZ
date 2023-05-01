package com.AtoZ.abc.mapper.order;

import com.AtoZ.abc.domain.order.Order;
import com.AtoZ.abc.domain.order.OrderItem;
import com.AtoZ.abc.dto.order.OrderDto;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    default OrderDto.OrderResponseDto orderToOrderResponseDto(Order order) {
        return OrderDto.OrderResponseDto.builder()
                .totalPrice(getTotalPrice(order))
                .orderItemResponseDtos(getOrderItemResponseDtoList(order))
                .build();
    }

    default List<OrderDto.OrderItemResponseDto> getOrderItemResponseDtoList(Order order) {
        List<OrderDto.OrderItemResponseDto> orderItemResponseDtos = new ArrayList<>();

        List<OrderItem> orderItems = order.getOrderItems();

        for (OrderItem orderItem : orderItems) {
            orderItemResponseDtos.add(OrderDto.OrderItemResponseDto.builder()
                    .itemName(orderItem.getName())
                    .itemPrice(orderItem.getPrice())
                    .itemQuantity(orderItem.getQuantity())
                    .build());
        }

        return orderItemResponseDtos;
    }


    default int getTotalPrice(Order order) {
        int result = 0;
        List<OrderItem> orderItems = order.getOrderItems();

        for (OrderItem orderItem : orderItems) {
            result += orderItem.getPrice() * orderItem.getQuantity();
        }

        return result;
    }

}
