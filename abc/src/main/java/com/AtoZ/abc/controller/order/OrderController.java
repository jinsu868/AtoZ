package com.AtoZ.abc.controller.order;

import com.AtoZ.abc.dto.order.OrderDto;
import com.AtoZ.abc.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    //pass
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/new")
    public OrderDto.OrderResponseDto createOrder(@RequestBody OrderDto.OrderPostDto orderPostDto) {
        return orderService.createOrder(orderPostDto);
    }

    //pass
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<OrderDto.OrderResponseDto> findOrders(@RequestParam Long userId) {
        return orderService.findOrders(userId);
    }

    //pass
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete")
    public void deleteOrder(@RequestParam Long orderId) {
        orderService.deleteOrder(orderId);
    }
}
