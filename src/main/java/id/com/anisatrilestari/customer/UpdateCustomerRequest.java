package id.com.anisatrilestari.customer;

import jakarta.validation.constraints.NotNull;

// Record untuk menerima permintaan update data pelanggan
public record UpdateCustomerRequest(
        @NotNull(message = "Id cannot be null") // Validasi agar ID wajib diisi
        Long id,
        String name,
        String phoneNumber) {
}
