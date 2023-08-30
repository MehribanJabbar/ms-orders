package az.ingress.msorders.service;


import az.ingress.msorders.dao.entity.OrderEntity;
import az.ingress.msorders.client.TicketClient;
import az.ingress.msorders.dao.repository.OrderRepository;
import az.ingress.msorders.dto.request.SaveOrderRequest;
import az.ingress.msorders.dto.response.OrderResponse;
import az.ingress.msorders.enums.OrderStatus;
import az.ingress.msorders.exception.NotFoundException;
import az.ingress.msorders.queue.QueueListener;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static az.ingress.msorders.mapper.OrderMapper.*;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final TicketClient ticketClient;
    private final QueueListener queueListener;

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
        order.setStatus(OrderStatus.WAITING);
        order.setOrderNumber(UUID.randomUUID().toString());
        orderRepository.save(order);
        ticketClient.saveTicket(createTicketRequestFromOrder(order));
    }

    public void changeStatus(Long id){
        var order = orderRepository.findById(id)
                .orElseThrow(()->new NotFoundException("ORDER_NOT_FOUND"));
        order.setStatus(OrderStatus.DONE);
        orderRepository.save(order);
    }


}
