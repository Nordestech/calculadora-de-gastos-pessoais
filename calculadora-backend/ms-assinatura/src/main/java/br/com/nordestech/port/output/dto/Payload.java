package br.com.nordestech.port.output.dto;

import br.com.nordestech.domain.model.Address;
import br.com.nordestech.domain.model.Customer;
import br.com.nordestech.domain.model.Item;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;

@Builder
public record Payload(

        List<Item> items,

        @JsonProperty("order_nsu")
        String orderNsu,

        @JsonProperty("redirect_url")
        String redirectUrl,

        @JsonProperty("webhook_url")
        String webhookUrl,

        Customer customer,

        Address address

) {
}
