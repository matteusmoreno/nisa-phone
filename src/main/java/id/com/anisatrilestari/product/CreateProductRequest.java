package id.com.anisatrilestari.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

// Permintaan untuk membuat produk baru
public record CreateProductRequest(
        @NotBlank(message = "Name is required") // Nama produk tidak boleh kosong
        String name,
        @NotNull(message = "Price is required") // Harga produk tidak boleh null
        BigDecimal price) {
}

