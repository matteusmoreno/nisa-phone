package id.com.anisatrilestari.customer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

// Controller REST untuk endpoint terkait pelanggan
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // Endpoint untuk membuat pelanggan baru
    @PostMapping("/create")
    public ResponseEntity<CustomerDetailsResponse> createCustomer(@RequestBody CreateCustomerRequest request, UriComponentsBuilder uriBuilder) {
        Customer customer = customerService.createCustomer(request);
        URI uri = uriBuilder.path("/customers/{id}").buildAndExpand(customer.getId()).toUri();

        return ResponseEntity.created(uri).body(new CustomerDetailsResponse(customer));
    }

    // Endpoint untuk mengambil data pelanggan berdasarkan ID
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDetailsResponse> getCustomer(@PathVariable Long id) {
        Customer customer = customerService.findCustomerById(id);
        return ResponseEntity.ok(new CustomerDetailsResponse(customer));
    }

    // Endpoint untuk memperbarui data pelanggan
    @PutMapping("/update")
    public ResponseEntity<CustomerDetailsResponse> updateCustomer(@RequestBody UpdateCustomerRequest request) {
        Customer customer = customerService.updateCustomer(request);
        return ResponseEntity.ok(new CustomerDetailsResponse(customer));
    }

    // Endpoint untuk menghapus pelanggan berdasarkan ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
