package com.example.msorders.mapper;

import com.example.msorders.dao.entity.OrderEntity;
import com.example.msorders.dto.request.SaveOrderRequest;
import com.example.msorders.dto.request.UpdateOrderRequest;
import com.example.msorders.dto.response.OrderResponse;
import com.example.msorders.model.request.SaveTicketRequest;

public class OrderMapper {
    public static OrderResponse buildToResponse(OrderEntity order){
        return OrderResponse.builder()
                .id(order.getId())
                .userId(order.getUserId())
                .orderNumber(order.getOrderNumber())
                .status(order.getStatus())
                .orderDetails(order.getOrderDetails())
                .build();
    }

    public static OrderEntity buildToEntity(SaveOrderRequest request){
        return OrderEntity.builder()
                .userId(request.getUserId())
                .orderDetails(request.getOrderDetails())
                .build();
    }

    public static void updateToOrder(OrderEntity order, UpdateOrderRequest request){
        order.setOrderDetails(request.getOrderDetails());
        order.setUserId(request.getUserId());
        order.setStatus(request.getStatus());
    }


    public static SaveTicketRequest createTicketRequestFromOrder(OrderEntity order){
        return SaveTicketRequest.builder()
                .orderId(order.getId())
                .trackingCode(order.getOrderNumber())
                .ticketDetails(order.getOrderDetails())
                .build();
    }
}
