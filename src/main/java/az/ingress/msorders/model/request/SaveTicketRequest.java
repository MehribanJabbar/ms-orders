package az.ingress.msorders.model.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SaveTicketRequest {
     String ticketDetails;
     String trackingCode;
     Long orderId;
}
