package trabalhoga.ecommerce.application.services;

import org.springframework.stereotype.Service;
import trabalhoga.ecommerce.application.domain.Customer;
import trabalhoga.ecommerce.application.domain.Order;
import trabalhoga.ecommerce.application.domain.Payment;
import trabalhoga.ecommerce.application.domain.enums.PaymentStatus;
import trabalhoga.ecommerce.application.ports.OrderRepositoryPort;
import trabalhoga.ecommerce.application.ports.OrderServicePort;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class OrderServiceImpl implements OrderServicePort
{

    private final OrderRepositoryPort orderRepositoryPort;

    public OrderServiceImpl (OrderRepositoryPort orderRepositoryPort)
    {
        this.orderRepositoryPort = orderRepositoryPort;
    }

    @Override
    public List<Order> findAll ()
    {
        return orderRepositoryPort.findAll();
    }

    @Override
    public Optional<Order> findById (UUID orderId)
    {
        return orderRepositoryPort.findById(orderId);
    }

    @Override
    public List<Order> findAllByCustomer (Customer customer)
    {
        return orderRepositoryPort.findAllByCustomer(customer);
    }

    @Override
    public Order createOrder (Order order)
    {
        order.setPayment(Payment.builder().status(PaymentStatus.PENDING).build());
        return orderRepositoryPort.createOrder(order);
    }

    @Override
    public Order payOrder (Order order)
    {
        order.setPayment(Payment.builder().status(PaymentStatus.PAID).build());
        return orderRepositoryPort.createOrder(order);
    }

    @Override
    public Order cancelOrder (Order order)
    {
        order.setPayment(Payment.builder().status(PaymentStatus.CANCELED).build());
        return orderRepositoryPort.createOrder(order);
    }
}
