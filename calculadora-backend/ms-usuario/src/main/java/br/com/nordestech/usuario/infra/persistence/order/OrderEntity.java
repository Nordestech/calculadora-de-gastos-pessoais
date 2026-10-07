package br.com.nordestech.usuario.infra.persistence.order;

import br.com.nordestech.usuario.domain.model.enums.StatusPayment;
import br.com.nordestech.usuario.infra.persistence.usuario.UsuarioEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "ORDERS")
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nsu", unique = true, nullable = false)
    private String nsu;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_payment")
    private StatusPayment statusPayment;

    @ManyToOne()
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuarioOrders;

    @Column(name = "valid_from")
    private LocalDate validFrom;

    @Column(name = "valid_to")
    private LocalDate validTo;

    public OrderEntity(String nsu, StatusPayment statusPayment, UsuarioEntity usuarioOrders) {
        this.nsu = nsu;
        this.statusPayment = statusPayment;
        this.usuarioOrders = usuarioOrders;
    }
}
