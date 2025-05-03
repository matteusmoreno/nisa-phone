package id.com.anisatrilestari.sale;

import id.com.anisatrilestari.customer.Customer;
import id.com.anisatrilestari.product.Product;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

// Entitas yang merepresentasikan tabel "sales" di database
@Entity
@Table(name = "sales")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
public class Sale {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // ID yang akan terisi otomatis
    private Long id;

    // Relasi dengan entitas Customer, mengindikasikan pelanggan yang melakukan pembelian
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false) // Kolom customer_id yang tidak boleh kosong
    private Customer customer;

    // Relasi Many-to-Many dengan produk, mengindikasikan produk yang dibeli dalam transaksi
    @ManyToMany
    @JoinTable(
            name = "sale_products", // Tabel penghubung antara sale dan product
            joinColumns = @JoinColumn(name = "sale_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

    // Total harga dari semua produk yang dibeli
    private BigDecimal totalPrice;

    // Waktu saat transaksi penjualan dilakukan
    private LocalDateTime dateOfSale;
}
