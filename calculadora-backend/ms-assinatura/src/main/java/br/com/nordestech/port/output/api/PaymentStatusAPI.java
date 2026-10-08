package br.com.nordestech.port.output.api;

import br.com.nordestech.presentation.rest.response.PaymentStatusResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "PaymentStatusAPI",
        url = "${URL_API}"
)
public interface PaymentStatusAPI {

    @GetMapping("/status/{orderNsu}")
    PaymentStatusResponseDTO checkPaymentStatus(@PathVariable("orderNsu") String orderNsu);

}
