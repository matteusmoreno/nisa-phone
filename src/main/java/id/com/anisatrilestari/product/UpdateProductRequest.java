package id.com.anisatrilestari.product;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

// Permintaan untuk memperbarui produk
public record UpdateProductRequest(
        @NotNull(message = "ID cannot be null") // ID harus diisi
        Long id,
        String name,
        BigDecimal price) {
}
