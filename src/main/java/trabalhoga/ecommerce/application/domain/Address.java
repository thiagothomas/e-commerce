package trabalhoga.ecommerce.application.domain;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class Address {

    private UUID id;
    private String street;
    private String number;
    private String complement;
    private String cep;
    private City city;

}
