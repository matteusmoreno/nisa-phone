package id.com.anisatrilestari.customer;

import jakarta.validation.constraints.NotNull;

public record UpdateCustomerRequest(
        @NotNull(message = "Id cannot be null")
        Long id,
        String name,
        String phoneNumber) {
}
