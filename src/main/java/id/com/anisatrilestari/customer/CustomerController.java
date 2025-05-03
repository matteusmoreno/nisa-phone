package id.com.anisatrilestari.customer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/create")
    public ResponseEntity<CustomerDetailsResponse> createCustomer(@RequestBody CreateCustomerRequest request, UriComponentsBuilder uriBuilder) {
        Customer customer = customerService.createCustomer(request);
        URI uri = uriBuilder.path("/customers/{id}").buildAndExpand(customer.getId()).toUri();

        return ResponseEntity.created(uri).body(new CustomerDetailsResponse(customer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDetailsResponse> getCustomer(@PathVariable Long id) {
        Customer customer = customerService.findCustomerById(id);
        return ResponseEntity.ok(new CustomerDetailsResponse(customer));
    }

    @PutMapping("/update")
    public ResponseEntity<CustomerDetailsResponse> updateCustomer(@RequestBody UpdateCustomerRequest request) {
        Customer customer = customerService.updateCustomer(request);
        return ResponseEntity.ok(new CustomerDetailsResponse(customer));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
