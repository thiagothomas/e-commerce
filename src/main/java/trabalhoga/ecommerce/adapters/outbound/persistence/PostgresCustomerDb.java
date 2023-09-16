package trabalhoga.ecommerce.adapters.outbound.persistence;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import trabalhoga.ecommerce.adapters.outbound.persistence.entities.CustomerEntity;
import trabalhoga.ecommerce.adapters.outbound.persistence.repositories.SpringDataPostgresCustomerRepository;
import trabalhoga.ecommerce.application.domain.Customer;
import trabalhoga.ecommerce.application.ports.CustomerRepositoryPort;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@Primary
public class PostgresCustomerDb implements CustomerRepositoryPort
{

    private final SpringDataPostgresCustomerRepository repository;

    public PostgresCustomerDb (final SpringDataPostgresCustomerRepository repository)
    {
        this.repository = repository;
    }

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<Customer> findAll ()
    {
        return repository.findAll().stream().map(entity -> modelMapper.map(entity, Customer.class))
                        .collect(Collectors.toList());
    }

    @Override
    public Optional<Customer> findById (UUID customerId)
    {
        Optional<CustomerEntity> customerEntity = repository.findById(customerId);
        return customerEntity.map(entity -> modelMapper.map(entity, Customer.class));
    }

    @Override
    public Optional<Customer> findByEmail (String customerEmail)
    {
        Optional<CustomerEntity> customerEntity = repository.findByEmail(customerEmail);
        return customerEntity.map(entity -> modelMapper.map(entity, Customer.class));
    }

    @Override
    public Customer save (Customer customer)
    {
        CustomerEntity customerEntity = repository.save(modelMapper.map(customer, CustomerEntity.class));

        return modelMapper.map(customerEntity, Customer.class);
    }
}
