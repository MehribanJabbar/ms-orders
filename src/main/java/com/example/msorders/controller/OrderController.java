package com.example.msorders.controller;

import com.example.msorders.dto.request.SaveOrderRequest;
import com.example.msorders.dto.request.UpdateOrderRequest;
import com.example.msorders.dto.response.OrderResponse;
import com.example.msorders.enums.OrderStatus;
import com.example.msorders.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/orders")
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    @ResponseStatus(OK)
    public OrderResponse findOrderById(@PathVariable Long id) {
        return orderService.findOrderById(id);
    }

    @GetMapping("/user/{user-id}")
    @ResponseStatus(OK)
    public List<OrderResponse> findOrdersByUserId(@PathVariable("user-id") Long userId) {
        return orderService.findOrdersByUserId(userId);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public void saveOrder(@RequestBody SaveOrderRequest request) {
        orderService.saveOrder(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void updateOrder(@PathVariable Long id, @RequestBody UpdateOrderRequest request) {
        orderService.updateOrder(id, request);
    }

    @PutMapping("/{id}/status")
    @ResponseStatus(OK)
    public void changeStatus(@PathVariable Long id, @RequestBody OrderStatus status) {
        orderService.changeStatus(id, status);
    }
}
