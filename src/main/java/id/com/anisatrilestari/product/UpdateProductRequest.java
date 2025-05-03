package id.com.anisatrilestari.product;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record UpdateProductRequest(
        @NotNull(message = "ID cannot be null")
        Long id,
        String name,
        BigDecimal price) {
}
