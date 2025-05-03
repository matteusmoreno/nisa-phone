package id.com.anisatrilestari.sale;

import jakarta.validation.constraints.NotNull;
import java.util.List;

// Permintaan untuk membuat penjualan baru, berisi ID customer dan daftar produk yang dibeli
public record CreateSaleRequest(
        @NotNull(message = "Customer ID tidak boleh null") // Validasi bahwa ID customer tidak boleh kosong
        Long customerId,

        @NotNull(message = "Product IDs tidak boleh null") // Validasi bahwa daftar ID produk tidak boleh kosong
        List<Long> products) {
}
