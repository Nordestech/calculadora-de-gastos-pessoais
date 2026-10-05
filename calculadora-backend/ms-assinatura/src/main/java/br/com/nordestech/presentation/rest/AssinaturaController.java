package br.com.nordestech.presentation.rest;

import br.com.nordestech.port.output.service.CheckoutService;
import br.com.nordestech.presentation.rest.request.PayloadRequestDTO;
import br.com.nordestech.presentation.rest.response.CheckoutResponseDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/assinatura")
@Slf4j
@RequiredArgsConstructor
@Tag(name = "Assinatura", description = "Endpoint para gerenciamento da assinatura")
public class AssinaturaController {

    private final CheckoutService checkoutService;

    @PostMapping("/checkout/{id}")
    public ResponseEntity<CheckoutResponseDTO> checkoutLink(
            @PathVariable("id") String usuarioId,
            @RequestBody @Valid PayloadRequestDTO payloadRequestDTO){

        log.info("Request de checkout recebida com sucesso: {}", payloadRequestDTO);
        CheckoutResponseDTO checkoutResponseDTO = checkoutService.executeCheckout(payloadRequestDTO);



        log.info("Checkout criado com sucesso: {}", checkoutResponseDTO);
        return ResponseEntity.status(HttpStatus.OK).body(checkoutResponseDTO);

    }

}
