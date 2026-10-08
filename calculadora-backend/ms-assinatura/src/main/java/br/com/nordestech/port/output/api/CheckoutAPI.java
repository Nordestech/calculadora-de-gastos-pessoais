package br.com.nordestech.port.output.api;

import br.com.nordestech.port.output.dto.Payload;
import br.com.nordestech.presentation.rest.response.CheckoutResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "CheckoutAPI",
        url = "${URL_API}"
)
public interface CheckoutAPI {

    @PostMapping("/create")
    CheckoutResponseDTO createCheckoutURL(@RequestBody Payload payload);

}
