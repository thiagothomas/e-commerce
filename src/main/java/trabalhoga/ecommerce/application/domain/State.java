package trabalhoga.ecommerce.application.domain;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class State {

    private UUID id;
    private String name;

}
