package br.com.nordestech.presentation.rest.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record CheckoutResponseDTO(

        @JsonProperty("checkout_url")
        String checkoutUrl

) {

}