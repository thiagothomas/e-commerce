package trabalhoga.ecommerce.application.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import trabalhoga.ecommerce.application.domain.enums.PaymentStatus;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Payment {

    private UUID id;
    private PaymentStatus status;

}
