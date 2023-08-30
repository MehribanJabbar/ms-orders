package az.ingress.msorders.queue;

import az.ingress.msorders.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class QueueListener {
    private final OrderService orderService;
    private final ObjectMapper objectMapper;

    @RabbitListener(queues = "${rabbitmq.queue.order}")
    public void changeStatus(String message) {
        try {
            var id = objectMapper.readValue(message, Long.class);
            orderService.changeStatus(id);
            log.info("Order status changed for ID: {}", id);
        } catch (Exception e) {
            log.warn("Error processing message: {}", e.getMessage(), e);
            throw new RuntimeException("Error processing message", e);
        }
    }
}

