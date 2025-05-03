package id.com.anisatrilestari.customer;

import jakarta.validation.constraints.NotBlank;

public record CreateCustomerRequest(
        @NotBlank(message = "Name is required")
        String name,
        String phoneNumber) {
}
