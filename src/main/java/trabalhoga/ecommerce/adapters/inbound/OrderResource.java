package trabalhoga.ecommerce.adapters.inbound;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import trabalhoga.ecommerce.adapters.dto.OrderDto;
import trabalhoga.ecommerce.application.domain.Customer;
import trabalhoga.ecommerce.application.domain.Order;
import trabalhoga.ecommerce.application.ports.OrderServicePort;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderResource
{

    @Autowired
    private OrderServicePort orderServicePort;

    @GetMapping("/{id}")
    public ResponseEntity<Order> get (@PathVariable UUID id)
    {
        Optional<Order> order = orderServicePort.findById(id);

        return order.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(params = {"customerId"})
    public ResponseEntity<List<Order>> getByCustomerId (@RequestParam("customerId") UUID customerId)
    {
        return ResponseEntity.ok(orderServicePort.findAllByCustomer(Customer.builder().id(customerId).build()));
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAll() {
        return ResponseEntity.ok(orderServicePort.findAll());
    }

    @PostMapping
    public ResponseEntity<Order> create (@RequestBody @Valid OrderDto orderDto)
    {
        Order order = new Order();
        BeanUtils.copyProperties(orderDto, order);
        order = orderServicePort.createOrder(order);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(order.getId())
                        .toUri();

        return ResponseEntity.created(uri).body(order);
    }

    @PutMapping("/{id}/pay")
    public ResponseEntity<Order> pay (@PathVariable UUID id) {
        Optional<Order> order = orderServicePort.findById(id);

        return order.map(value -> ResponseEntity.ok(orderServicePort.payOrder(value)))
                        .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<Order> cancel (@PathVariable UUID id) {
        Optional<Order> order = orderServicePort.findById(id);

        return order.map(value -> ResponseEntity.ok(orderServicePort.cancelOrder(value)))
                        .orElseGet(() -> ResponseEntity.notFound().build());

    }
    
}
