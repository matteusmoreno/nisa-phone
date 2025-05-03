package id.com.anisatrilestari.sale;

import id.com.anisatrilestari.customer.Customer;
import id.com.anisatrilestari.product.Product;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "sales")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
public class Sale {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToMany
    @JoinTable(
            name = "sale_products",
            joinColumns = @JoinColumn(name = "sale_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;
    private BigDecimal totalPrice;
    private LocalDateTime dateOfSale;
}
