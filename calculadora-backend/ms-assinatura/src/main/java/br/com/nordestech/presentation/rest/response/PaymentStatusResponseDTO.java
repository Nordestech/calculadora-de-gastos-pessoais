package br.com.nordestech.presentation.rest.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record PaymentStatusResponseDTO(

        Boolean success,

        Boolean paid,

        BigDecimal amount,

        @JsonProperty("paid_amount")
        BigDecimal paidAmount,

        Integer installments,

        @JsonProperty("capture_method")
        String captureMethod

) {
}