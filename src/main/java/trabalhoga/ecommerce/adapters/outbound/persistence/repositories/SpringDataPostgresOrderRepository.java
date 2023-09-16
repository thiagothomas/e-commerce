package trabalhoga.ecommerce.adapters.outbound.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trabalhoga.ecommerce.adapters.outbound.persistence.entities.CustomerEntity;
import trabalhoga.ecommerce.adapters.outbound.persistence.entities.OrderEntity;

import java.util.List;
import java.util.UUID;

@Repository
public interface SpringDataPostgresOrderRepository extends JpaRepository<OrderEntity, UUID> {

    List<OrderEntity> findAllByCustomer(CustomerEntity customer);

}
