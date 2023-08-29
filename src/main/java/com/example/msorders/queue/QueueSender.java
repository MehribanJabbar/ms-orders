package com.example.msorders.queue;

import com.example.msorders.dao.entity.OrderEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QueueSender {
    private final ObjectMapper objectMapper;
    private final AmqpTemplate amqpTemplate;

    @SneakyThrows
    public void senderMessage(OrderEntity order){
        amqpTemplate.convertAndSend("ORDER_Q", objectMapper.writeValueAsString(order));
    }
}
