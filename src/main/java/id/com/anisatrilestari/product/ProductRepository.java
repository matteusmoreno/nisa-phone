package id.com.anisatrilestari.product;

import org.springframework.data.jpa.repository.JpaRepository;

// Repository untuk operasi CRUD terhadap entitas Produk
public interface ProductRepository extends JpaRepository<Product, Long> {
}

