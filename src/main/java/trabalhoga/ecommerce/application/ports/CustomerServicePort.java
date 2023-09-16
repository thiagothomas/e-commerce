package trabalhoga.ecommerce.application.ports;

import trabalhoga.ecommerce.application.domain.Customer;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerServicePort
{

    List<Customer> findAll();
    Optional<Customer> findById(UUID customerId);
    Optional<Customer> findByEmail(String customerEmail);
    Customer save(Customer customer);

}
