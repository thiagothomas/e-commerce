package trabalhoga.ecommerce.application.services;

import org.springframework.stereotype.Service;
import trabalhoga.ecommerce.application.domain.Customer;
import trabalhoga.ecommerce.application.ports.CustomerRepositoryPort;
import trabalhoga.ecommerce.application.ports.CustomerServicePort;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CustomerServiceImpl implements CustomerServicePort
{

    private final CustomerRepositoryPort customerRepositoryPort;

    public CustomerServiceImpl(CustomerRepositoryPort customerRepositoryPort) {
        this.customerRepositoryPort = customerRepositoryPort;
    }

    @Override
    public List<Customer> findAll ()
    {
        return customerRepositoryPort.findAll();
    }

    @Override
    public Optional<Customer> findById (UUID customerId)
    {
        return customerRepositoryPort.findById(customerId);
    }

    @Override
    public Optional<Customer> findByEmail (String customerEmail)
    {
        return customerRepositoryPort.findByEmail(customerEmail);
    }

    @Override
    public Customer save (Customer customer)
    {
        return customerRepositoryPort.save(customer);
    }
}
