package id.com.anisatrilestari.product;

import java.math.BigDecimal;

// Response DTO untuk mengirim detail produk ke klien
public record ProductDetailsResponse(
        Long id,
        String name,
        BigDecimal price) {

    // Konstruktor untuk mengisi data dari entitas produk
    public ProductDetailsResponse(Product product) {
        this(
                product.getId(),
                product.getName(),
                product.getPrice()
        );
    }
}

