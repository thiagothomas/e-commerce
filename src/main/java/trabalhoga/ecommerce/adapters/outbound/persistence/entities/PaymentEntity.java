package trabalhoga.ecommerce.adapters.outbound.persistence.entities;

import jakarta.persistence.*;
import lombok.Data;
import trabalhoga.ecommerce.application.domain.enums.PaymentStatus;

import java.util.UUID;

@Data
@Entity
@Table(name = "payment")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;

    private PaymentStatus status;

}
