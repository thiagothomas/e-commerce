package trabalhoga.ecommerce.application.ports;

import trabalhoga.ecommerce.application.domain.Customer;
import trabalhoga.ecommerce.application.domain.Order;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderServicePort
{

    List<Order> findAll();
    Optional<Order> findById(UUID orderId);
    List<Order> findAllByCustomer(Customer customer);
    Order createOrder(Order order);
    Order payOrder(Order order);
    Order cancelOrder(Order order);

}
