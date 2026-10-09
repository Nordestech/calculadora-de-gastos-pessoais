package br.com.nordestech.usuario.port.output.publisher;

import br.com.nordestech.usuario.infra.config.RabbitMQConfig;
import br.com.nordestech.usuario.port.output.dto.EmailHtmlRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class WelcomeEmailEventPublisher {

    private final RabbitTemplate rabbitTemplate;

    public void publishPaymentApprovedEvent(EmailHtmlRequest emailHtmlRequest) {

        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EMAIL_EXCHANGE,
                RabbitMQConfig.ROUTING_KEY_WELCOME_EMAIL,
                emailHtmlRequest
        );

        log.info("Enviando e-mail de boas vindas ao usuario: 'nomeCompleto': '{}'", emailHtmlRequest.nomeCompleto());
    }

}