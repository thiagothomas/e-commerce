package trabalhoga.ecommerce.adapters.outbound.persistence;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import trabalhoga.ecommerce.adapters.outbound.persistence.repositories.*;
import trabalhoga.ecommerce.application.ports.*;

@Component
@Primary
public class MySqlAdapter implements
        AddressRepositoryPort,
        CategoryRepositoryPort,
        CustomerRepositoryPort,
        OrderRepositoryPort,
        ProductRepositoryPort
{

    private final SpringDataMySqlAddressRepository addressRepository;
    private final SpringDataMySqlCategoryRepository categoryRepository;
    private final SpringDataMySqlCustomerRepository customerRepository;
    private final SpringDataMySqlOrderRepository orderRepository;
    private final SpringDataMySqlProductRepository productRepository;

    public MySqlAdapter(final SpringDataMySqlAddressRepository addressRepository,
                        final SpringDataMySqlCategoryRepository categoryRepository,
                        final SpringDataMySqlCustomerRepository customerRepository,
                        final SpringDataMySqlOrderRepository orderRepository,
                        final SpringDataMySqlProductRepository productRepository)
    {
        this.addressRepository = addressRepository;
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @Autowired
    private ModelMapper modelMapper;

}
