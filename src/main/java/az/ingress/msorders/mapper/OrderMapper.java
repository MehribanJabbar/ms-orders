package az.ingress.msorders.mapper;

import az.ingress.msorders.dao.entity.OrderEntity;
import az.ingress.msorders.dto.request.SaveOrderRequest;
import az.ingress.msorders.dto.response.OrderResponse;
import az.ingress.msorders.model.request.SaveTicketRequest;

public class OrderMapper {
    public static OrderResponse buildToResponse(OrderEntity order) {
        return OrderResponse.builder()
                .id(order.getId())
                .userId(order.getUserId())
                .orderNumber(order.getOrderNumber())
                .status(order.getStatus())
                .orderDetails(order.getOrderDetails())
                .build();
    }

    public static OrderEntity buildToEntity(SaveOrderRequest request) {
        return OrderEntity.builder()
                .userId(request.getUserId())
                .orderDetails(request.getOrderDetails())
                .build();
    }


    public static SaveTicketRequest createTicketRequestFromOrder(OrderEntity order) {
        return SaveTicketRequest.builder()
                .orderId(order.getId())
                .trackingCode(order.getOrderNumber())
                .ticketDetails(order.getOrderDetails())
                .build();
    }
}
