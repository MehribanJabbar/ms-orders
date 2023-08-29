package com.example.msorders.dto.request;

import com.example.msorders.enums.CardType;
import com.example.msorders.enums.OrderStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SaveOrderRequest {
     Long userId;
     String orderDetails;
     CardType cardType;
}
