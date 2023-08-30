package az.ingress.msorders.client;

import az.ingress.msorders.model.request.SaveTicketRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ms-ticket",
        url = "http://localhost:8989")
public interface TicketClient {

    @PostMapping(path = "/v1/tickets")
    void saveTicket(@RequestBody SaveTicketRequest request);
}
