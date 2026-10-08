package br.com.nordestech.port.output.service;

import br.com.nordestech.port.output.api.PaymentStatusAPI;
import br.com.nordestech.port.output.exception.PaymentStatusException;
import br.com.nordestech.port.output.exception.PaymentStatusNotFoundException;
import br.com.nordestech.presentation.rest.response.PaymentStatusResponseDTO;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentStatusService {

    private final PaymentStatusAPI paymentStatusAPI;

    public PaymentStatusResponseDTO checkPaymentStatus(String orderNsu){
        try {
            return paymentStatusAPI.checkPaymentStatus(orderNsu);
        } catch (FeignException.NotFound e) {
            throw new PaymentStatusNotFoundException("PaymentStatusAPI", e.getMessage());
        } catch (FeignException e) {
            throw new PaymentStatusException("PaymentStatusAPI", e.getMessage());
        }
    }

}
