package com.example.msorders.service;


import com.example.msorders.client.TicketClient;
import com.example.msorders.dao.entity.OrderEntity;
import com.example.msorders.dao.repository.OrderRepository;
import com.example.msorders.dto.request.SaveOrderRequest;
import com.example.msorders.dto.request.UpdateOrderRequest;
import com.example.msorders.dto.response.OrderResponse;
import com.example.msorders.enums.OrderStatus;
import com.example.msorders.exception.NotFoundException;
import com.example.msorders.mapper.OrderMapper;
import com.example.msorders.model.enums.TicketStatus;
import com.example.msorders.model.request.SaveTicketRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.example.msorders.mapper.OrderMapper.*;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final TicketClient ticketClient;
    public OrderResponse findOrderById(Long id) {
        var order = orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("ORDER_NOT_FOUND"));
        return buildToResponse(order);
    }

    public List<OrderResponse> findOrdersByUserId(Long userId) {
        List<OrderEntity> orders = orderRepository.findAllByUserId(userId);
        List<OrderResponse> list = new ArrayList<>();
        for (OrderEntity order : orders) {
            list.add(buildToResponse(order));
        }
        return list;
    }

    @Transactional
    public void saveOrder(SaveOrderRequest request) {
        OrderEntity order = buildToEntity(request);
        order.setStatus(OrderStatus.PREPARING);
        order.setOrderNumber(UUID.randomUUID().toString());
        orderRepository.save(order);
        ticketClient.saveTicket(createTicketRequestFromOrder(order));
    }

    public void updateOrder(Long id, UpdateOrderRequest request){
        var order = orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("ORDER_NOT_FOUND"));
        OrderMapper.updateToOrder(order, request);
        orderRepository.save(order);
    }

    public void changeStatus(Long id, OrderStatus newStatus){
        var order = orderRepository.findById(id)
                .orElseThrow(()->new NotFoundException("ORDER_NOT_FOUND"));
        order.setStatus(newStatus);
        orderRepository.save(order);
    }


}
