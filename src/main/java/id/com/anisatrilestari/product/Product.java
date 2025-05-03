package id.com.anisatrilestari.product;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

// Entitas produk yang mewakili tabel 'products' di database
@Entity
@Table(name = "products")
@AllArgsConstructor // Konstruktor dengan semua argumen
@NoArgsConstructor  // Konstruktor tanpa argumen
@Builder            // Menyediakan builder pattern
@Getter @Setter     // Menghasilkan getter dan setter secara otomatis
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // ID dihasilkan secara otomatis oleh database
    private Long id;
    private String name;
    private BigDecimal price;
}
