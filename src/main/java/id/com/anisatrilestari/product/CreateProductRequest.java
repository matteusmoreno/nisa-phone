package id.com.anisatrilestari.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CreateProductRequest(
        @NotBlank(message = "Name is required")
        String name,
        @NotNull(message = "Price is required")
        BigDecimal price) {
}
