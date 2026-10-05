package br.com.nordestech.port.output.service;

import br.com.nordestech.port.output.api.CheckoutAPI;
import br.com.nordestech.port.output.exception.CheckoutException;
import br.com.nordestech.presentation.rest.request.PayloadRequestDTO;
import br.com.nordestech.presentation.rest.response.CheckoutResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckoutService {

    private final CheckoutAPI checkoutAPI;

    public CheckoutResponseDTO executeCheckout(PayloadRequestDTO payloadRequestDTO) {

        try {

            return checkoutAPI.createCheckoutURL(payloadRequestDTO);

        } catch (feign.FeignException e) {

            throw new CheckoutException("FeignException", e.getMessage());

        }
    }

}