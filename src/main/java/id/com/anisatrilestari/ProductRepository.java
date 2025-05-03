package id.com.anisatrilestari;

import id.com.anisatrilestari.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
