package br.com.nordestech.port.output.api;

import br.com.nordestech.presentation.rest.request.PayloadRequestDTO;
import br.com.nordestech.presentation.rest.response.CheckoutResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "CheckoutAPI",
        url = "http://localhost:8080/api/checkout"
)
public interface CheckoutAPI {

    @PostMapping("/new")
    CheckoutResponseDTO createCheckoutURL(@RequestBody PayloadRequestDTO payloadRequestDTO);

}
