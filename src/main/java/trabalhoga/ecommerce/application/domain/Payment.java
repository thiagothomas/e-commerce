package trabalhoga.ecommerce.application.domain;

import lombok.Builder;
import lombok.Data;
import trabalhoga.ecommerce.application.domain.enums.PaymentStatus;

import java.util.UUID;

@Data
@Builder
public class Payment {

    private UUID id;
    private PaymentStatus status;

}
