package trabalhoga.ecommerce.adapters.outbound.persistence.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;
    private String name;
    private String email;
    private String password;

    @OneToMany(mappedBy = "customer")
    private Set<OrderEntity> orders = new HashSet<>();

}
