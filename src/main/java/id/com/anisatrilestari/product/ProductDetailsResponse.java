package id.com.anisatrilestari.product;

import java.math.BigDecimal;

public record ProductDetailsResponse(
        Long id,
        String name,
        BigDecimal price) {
    public ProductDetailsResponse(Product product) {
        this(
                product.getId(),
                product.getName(),
                product.getPrice()
        );
    }
}
