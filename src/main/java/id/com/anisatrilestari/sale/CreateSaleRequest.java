package id.com.anisatrilestari.sale;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CreateSaleRequest(
        @NotNull(message = "Customer ID cannot be null")
        Long customerId,
        @NotNull(message = "Product IDs cannot be null")
        List<Long> products) {
}
