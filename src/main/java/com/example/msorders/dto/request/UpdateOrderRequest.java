package com.example.msorders.dto.request;

import com.example.msorders.enums.OrderStatus;
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
