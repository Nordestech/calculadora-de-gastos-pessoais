package br.com.nordestech.presentation.rest;

import br.com.nordestech.port.output.service.CheckoutService;
import br.com.nordestech.port.output.service.PaymentStatusService;
import br.com.nordestech.presentation.rest.request.PayloadRequestDTO;
import br.com.nordestech.presentation.rest.response.CheckoutResponseDTO;
import br.com.nordestech.presentation.rest.response.PaymentStatusResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/assinatura")
@Slf4j
@RequiredArgsConstructor
@Tag(name = "Assinatura", description = "Endpoint para gerenciamento da assinatura")
public class AssinaturaController {

    private final CheckoutService checkoutService;
    private final PaymentStatusService paymentStatusService;

    @Operation(summary = "Realiza o checkout da assinatura", description = "Realizar o checkout da assinatura por meio " +
            "de variável de URL e um body Payload")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Erro durante o fetch da api de pagamentos"),
            @ApiResponse(responseCode = "400", description = "Dados de requisição inválidos")
    })
    @PreAuthorize("hasAnyRole('FREE_ACCOUNT', 'PREMIUM_ACCOUNT')")
    @PostMapping("/checkout/{id}")
    public ResponseEntity<CheckoutResponseDTO> checkoutLink(
            @PathVariable("id") String usuarioId,
            @RequestBody @Valid PayloadRequestDTO payloadRequestDTO){

        log.info("Request de checkout recebida com sucesso: {}", payloadRequestDTO);
        CheckoutResponseDTO checkoutResponseDTO = checkoutService.executeCheckout(payloadRequestDTO, usuarioId);

        log.info("Checkout criado com sucesso: {}", checkoutResponseDTO);
        return ResponseEntity.status(HttpStatus.OK).body(checkoutResponseDTO);

    }

    @Operation(summary = "Realiza a verificação de status de pagamento", description = "Realizar a verificação do " +
            "status de pagamento por meio da orderNsu enviada na variável de URL")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Erro durante o fetch da api de pagamentos"),
            @ApiResponse(responseCode = "404", description = "Pagamento não encontrado na api")
    })
    @PreAuthorize("hasAnyRole('FREE_ACCOUNT', 'PREMIUM_ACCOUNT')")
    @GetMapping("/status/{orderNsu}")
    public ResponseEntity<PaymentStatusResponseDTO> checkPaymentStatus(@PathVariable("orderNsu") String orderNsu) {

        log.info("Request de verificação do status de pagamento recebida com sucesso: 'orderNsu': '{}'", orderNsu);
        PaymentStatusResponseDTO paymentStatusResponseDTO = paymentStatusService.checkPaymentStatus(orderNsu);

        log.info("Status de pagamento recebido com sucesso: 'paid': '{}'", paymentStatusResponseDTO.paid());
        return ResponseEntity.status(HttpStatus.OK).body(paymentStatusResponseDTO);

    }

}
