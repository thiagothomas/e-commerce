package trabalhoga.ecommerce.adapters.outbound.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trabalhoga.ecommerce.adapters.outbound.persistence.entities.PaymentEntity;

import java.util.UUID;

@Repository
public interface SpringDataPostgresPaymentRepository extends JpaRepository<PaymentEntity, UUID> {

}
