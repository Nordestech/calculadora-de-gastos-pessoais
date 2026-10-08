package br.com.nordestech.port.output.service;

import br.com.nordestech.port.output.api.CheckoutAPI;
import br.com.nordestech.port.output.dto.Payload;
import br.com.nordestech.port.output.exception.CheckoutException;
import br.com.nordestech.presentation.rest.request.PayloadRequestDTO;
import br.com.nordestech.presentation.rest.response.CheckoutResponseDTO;
import br.com.nordestech.usuario.domain.model.Order;
import br.com.nordestech.usuario.domain.service.order.CadastrarOrderUseCase;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class CheckoutService {

    private final CheckoutAPI checkoutAPI;
    private final CadastrarOrderUseCase cadastrarOrderUseCase;

    @Value("${URL_API}")
    private String url;

    public CheckoutResponseDTO executeCheckout(PayloadRequestDTO payloadRequestDTO, String usuarioId) {

        try {
            log.info("Gerando order para payload: 'usuarioId': '{}'", usuarioId);
            Order order = cadastrarOrderUseCase.execute(UUID.fromString(usuarioId));

            log.info("Order gerada: 'orderNsu': '{}'", order.getNsu());
            Payload payload = Payload.builder()
                    .items(payloadRequestDTO.items().stream().map(PayloadRequestDTO.ItemDTO::toModel).toList())
                    .orderNsu(order.getNsu())
                    .redirectUrl(url + "/redirect")
                    .webhookUrl(url + "/webhook")
                    .customer(payloadRequestDTO.customer().toModel())
                    .address(payloadRequestDTO.address().toModel())
                    .build();

            log.info("Payload criado com sucesso: 'orderNsu': '{}'", payload.orderNsu());
            return checkoutAPI.createCheckoutURL(payload);
        } catch (FeignException e) {
            throw new CheckoutException("Checkout", e.getMessage());
        }
    }

}