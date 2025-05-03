package id.com.anisatrilestari.customer;

import jakarta.persistence.*;
import lombok.*;

// Entitas yang merepresentasikan tabel "customers" di database
@Entity
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
public class Customer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // ID auto increment
    private Long id;

    // Nama pelanggan
    private String name;

    // Nomor telepon pelanggan
    private String phoneNumber;
}
