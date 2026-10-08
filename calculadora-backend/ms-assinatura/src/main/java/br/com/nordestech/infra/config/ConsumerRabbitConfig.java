package br.com.nordestech.infra.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JavaTypeMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsumerRabbitConfig {

    public static final String QUEUE_PAYMENT_APPROVED =
            "payment.approved.queue";

    @Bean
    public Queue paymentApprovedQueue() {
        return new Queue(QUEUE_PAYMENT_APPROVED, true);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {

        Jackson2JsonMessageConverter converter =
                new Jackson2JsonMessageConverter();

        converter.setTypePrecedence(
                Jackson2JavaTypeMapper.TypePrecedence.INFERRED
        );

        return converter;
    }
}