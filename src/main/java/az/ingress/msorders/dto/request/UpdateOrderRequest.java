package az.ingress.msorders.dto.request;

import az.ingress.msorders.enums.OrderStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateOrderRequest {
     String orderDetails;
     Long userId;
     OrderStatus status;
}
