package az.ingress.msorders.dto.response;

import az.ingress.msorders.enums.OrderStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderResponse {
     Long id;
     Long userId;
     String orderNumber;
     OrderStatus status;
     String orderDetails;
}
