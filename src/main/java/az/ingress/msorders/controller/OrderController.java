package az.ingress.msorders.controller;

import az.ingress.msorders.dto.request.SaveOrderRequest;
import az.ingress.msorders.dto.request.UpdateOrderRequest;
import az.ingress.msorders.dto.response.OrderResponse;
import az.ingress.msorders.enums.OrderStatus;
import az.ingress.msorders.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/orders")
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/{id}")
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


    @PutMapping("/{id}/status")
    @ResponseStatus(OK)
    public void changeStatus(@PathVariable Long id) {
        orderService.changeStatus(id);
    }
}
