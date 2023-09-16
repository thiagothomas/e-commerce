package trabalhoga.ecommerce.adapters.outbound.persistence;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import trabalhoga.ecommerce.adapters.outbound.persistence.entities.CustomerEntity;
import trabalhoga.ecommerce.adapters.outbound.persistence.entities.OrderEntity;
import trabalhoga.ecommerce.adapters.outbound.persistence.repositories.SpringDataPostgresOrderRepository;
import trabalhoga.ecommerce.application.domain.Customer;
import trabalhoga.ecommerce.application.domain.Order;
import trabalhoga.ecommerce.application.ports.OrderRepositoryPort;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@Primary
public class PostgresOrderDb implements OrderRepositoryPort
{

    private final SpringDataPostgresOrderRepository repository;

    public PostgresOrderDb (final SpringDataPostgresOrderRepository repository)
    {
        this.repository = repository;
    }

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<Order> findAll ()
    {
        return repository.findAll().stream().map(entity -> modelMapper.map(entity,
                                                                           Order.class))
                        .collect(Collectors.toList());
    }

    @Override
    public Optional<Order> findById (UUID orderId)
    {
        Optional<OrderEntity> orderEntity = repository.findById(orderId);
        return orderEntity.map(entity -> modelMapper.map(entity,
                                                         Order.class));
    }

    @Override
    public List<Order> findAllByCustomer (Customer customer)
    {
        return repository.findAllByCustomer(modelMapper.map(customer, CustomerEntity.class))
                        .stream()
                        .map(entity -> modelMapper.map(entity, Order.class))
                        .collect(Collectors.toList());
    }

    @Override
    public Order createOrder (Order order)
    {
        return save(order);
    }

    @Override
    public Order payOrder (Order order)
    {
        return save(order);
    }

    @Override
    public Order cancelOrder (Order order)
    {
        return save(order);
    }

    private Order save(Order order) {
        OrderEntity orderEntity = repository.save(modelMapper.map(order, OrderEntity.class));

        return modelMapper.map(orderEntity, Order.class);
    }
}
