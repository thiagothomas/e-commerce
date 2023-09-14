package trabalhoga.ecommerce.adapters.outbound.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trabalhoga.ecommerce.adapters.outbound.persistence.entities.CustomerEntity;

import java.util.UUID;

@Repository
public interface SpringDataMySqlCustomerRepository extends JpaRepository<CustomerEntity, UUID> {

}
