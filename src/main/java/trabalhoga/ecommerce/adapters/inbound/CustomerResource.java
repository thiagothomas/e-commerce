package trabalhoga.ecommerce.adapters.inbound;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import trabalhoga.ecommerce.adapters.dto.CustomerDto;
import trabalhoga.ecommerce.application.domain.Customer;
import trabalhoga.ecommerce.application.ports.CustomerServicePort;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/customers")
public class CustomerResource
{

    @Autowired
    private CustomerServicePort customerServicePort;

    @GetMapping("/{id}")
    public ResponseEntity<Customer> get (@PathVariable UUID id)
    {
        Optional<Customer> customer = customerServicePort.findById(id);

        return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(params = {"email"})
    public ResponseEntity<Customer> get (@Email @RequestParam("email") String email)
    {
        Optional<Customer> customer = customerServicePort.findByEmail(email);

        return customer.map(ResponseEntity::ok).orElseGet   (() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Customer>> get() {
        return ResponseEntity.ok(customerServicePort.findAll());
    }

    @PostMapping
    public ResponseEntity<Customer> create (@RequestBody @Valid CustomerDto customerDto)
    {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customer = customerServicePort.save(customer);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(customer.getId())
                        .toUri();

        return ResponseEntity.created(uri).body(customer);
    }
    
}
