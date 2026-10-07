package br.com.nordestech.port.input.consumer;

import br.com.nordestech.infra.config.ConsumerRabbitConfig;
import br.com.nordestech.port.input.dto.PaymentApprovedDTO;
import br.com.nordestech.usuario.domain.model.enums.StatusPayment;
import br.com.nordestech.usuario.domain.service.order.AtualizarOrderUseCase;
import br.com.nordestech.usuario.domain.service.usuario.AtualizarUsuarioUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RabbitMQConsumer {

    private final AtualizarUsuarioUseCase atualizarUsuarioUseCase;
    private final AtualizarOrderUseCase atualizarOrderUseCase;

    @RabbitListener(queues = ConsumerRabbitConfig.QUEUE_PAYMENT_APPROVED)
    public void checkPaymentApproved(PaymentApprovedDTO paymentApprovedDTO) {

        atualizarOrderUseCase.execute(paymentApprovedDTO.orderNsu(), StatusPayment.APPROVED);

        atualizarUsuarioUseCase.atualizarAssinatura(paymentApprovedDTO.orderNsu());

    }

}
