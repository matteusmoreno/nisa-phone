package id.com.anisatrilestari.customer;

import org.springframework.data.jpa.repository.JpaRepository;

// Repository JPA untuk operasi database pelanggan
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
