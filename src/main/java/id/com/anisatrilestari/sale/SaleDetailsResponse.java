package id.com.anisatrilestari.sale;

import id.com.anisatrilestari.customer.Customer;
import id.com.anisatrilestari.product.Product;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

// Respons untuk detail penjualan
public record SaleDetailsResponse(
        Long id,
        Customer customer,
        List<Product> products,
        BigDecimal totalPrice,
        LocalDateTime dateOfSale) {

    // Konstruktor untuk mengubah entitas Sale menjadi respons
    public SaleDetailsResponse(Sale sale) {
        this(
                sale.getId(),
                sale.getCustomer(),
                sale.getProducts(),
                sale.getTotalPrice(),
                sale.getDateOfSale()
        );
    }
}
