package com.example.msorders.client;

import com.example.msorders.model.request.SaveTicketRequest;
import com.example.msorders.model.response.TicketResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ms-ticket",
        url = "http://localhost:8989")
public interface TicketClient {

    @PostMapping(path = "/v1/tickets")
    void saveTicket(@RequestBody SaveTicketRequest request);
}
