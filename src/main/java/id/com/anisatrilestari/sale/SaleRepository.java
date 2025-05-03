package id.com.anisatrilestari.sale;

import org.springframework.data.jpa.repository.JpaRepository;

// Repository untuk entitas Sale yang mengelola operasi CRUD dengan database
public interface SaleRepository extends JpaRepository<Sale, Long> {
}
