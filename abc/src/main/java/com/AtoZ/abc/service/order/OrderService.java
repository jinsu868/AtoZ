package com.AtoZ.abc.service.order;

import com.AtoZ.abc.domain.User;
import com.AtoZ.abc.domain.item.Item;
import com.AtoZ.abc.domain.order.Delivery;
import com.AtoZ.abc.domain.order.Order;
import com.AtoZ.abc.domain.order.OrderItem;
import com.AtoZ.abc.dto.order.OrderDto;
import com.AtoZ.abc.mapper.order.DeliveryMapper;
import com.AtoZ.abc.mapper.order.OrderMapper;
import com.AtoZ.abc.repository.UserRepository;
import com.AtoZ.abc.repository.item.ItemRepository;
import com.AtoZ.abc.repository.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;
    private final DeliveryMapper deliveryMapper;
    private final OrderMapper orderMapper;

    @Transactional
    public OrderDto.OrderResponseDto createOrder(OrderDto.OrderPostDto orderPostDto) {
        log.info("userId : {}", orderPostDto.getUserId());
        User user = userRepository.findById(orderPostDto.getUserId()).orElseThrow();
        Delivery delivery = deliveryMapper.AddressToDelivery(user.getAddress());
        Order order = Order.builder()
                .delivery(delivery)
                .user(user)
                .orderItems(new ArrayList<>())
                .build();

        user.addOrder(order);

        for(OrderDto.OrderItemPostDto orderItemPostDto : orderPostDto.getOrderItemPostDtos()) {
            log.info("orderItemPostDto : {}", orderItemPostDto);
            Item item = itemRepository.findById(orderItemPostDto.getItemId()).orElseThrow();
            OrderItem orderItem = OrderItem.createOrderItem(item, order, orderItemPostDto.getOrderQuantity());
            order.addOrderItem(orderItem);
        }

        return orderMapper.orderToOrderResponseDto(orderRepository.save(order));
    }

    //userId로 주문 내역 조회
    public List<OrderDto.OrderResponseDto> findOrders(Long id) {
        List<Order> orders = orderRepository.findOrdersWithAll(id);
        List<OrderDto.OrderResponseDto> orderResponseDtos = new ArrayList<>();

        for (Order order : orders) {
            orderResponseDtos.add(orderMapper.orderToOrderResponseDto(order));
        }

        return orderResponseDtos;
    }

    //주문을 수정하는 경우는 없음. (보통 주문을 취소하고 다시 주문을 한다.)

    @Transactional
    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id).orElseThrow();
        List<OrderItem> orderItems = order.getOrderItems();
        User user = order.getUser();

        for (OrderItem orderItem : orderItems) {
            orderItem.cancel();
        }

        //cascade로 Order, Delivery, OrderItem 삭제
        user.getOrders().remove(order);
        orderRepository.delete(order);
    }
}
