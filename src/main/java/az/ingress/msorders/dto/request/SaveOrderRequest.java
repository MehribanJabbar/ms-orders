package az.ingress.msorders.dto.request;

import az.ingress.msorders.enums.CardType;
import lombok.*;
import lombok.experimental.FieldDefaults;

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
