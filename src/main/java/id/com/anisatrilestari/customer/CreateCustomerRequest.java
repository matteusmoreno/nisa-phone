package id.com.anisatrilestari.customer;

import jakarta.validation.constraints.NotBlank;

// Record ini digunakan untuk menerima data saat membuat pelanggan baru
public record CreateCustomerRequest(
        @NotBlank(message = "Name is required") // Validasi agar nama tidak boleh kosong
        String name,
        String phoneNumber) {
}
