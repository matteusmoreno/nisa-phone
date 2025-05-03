package id.com.anisatrilestari.customer;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

// Service yang berisi logika bisnis untuk pelanggan
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Membuat pelanggan baru
    @Transactional
    public Customer createCustomer(CreateCustomerRequest request) {
        Customer customer = Customer.builder()
                .name(request.name())
                .phoneNumber(request.phoneNumber())
                .build();

        customerRepository.save(customer);

        return customer;
    }

    // Mencari pelanggan berdasarkan ID
    public Customer findCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    // Memperbarui data pelanggan
    @Transactional
    public Customer updateCustomer(UpdateCustomerRequest request) {
        Customer customer = customerRepository.findById(request.id())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        if (request.name() != null) {
            customer.setName(request.name());
        }
        if (request.phoneNumber() != null) {
            customer.setPhoneNumber(request.phoneNumber());
        }

        customerRepository.save(customer);
        return customer;
    }

    // Menghapus pelanggan berdasarkan ID
    @Transactional
    public void deleteCustomer(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        customerRepository.delete(customer);
    }
}
