package com.example.msorders.model.response;

import com.example.msorders.model.enums.TicketStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TicketResponse {
     Long id;
     String ticketNumber;
     String trackingCode;
     Long orderId;
     LocalDate createdAt;
     TicketStatus ticketStatus;
}
