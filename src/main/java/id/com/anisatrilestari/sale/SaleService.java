package id.com.anisatrilestari.sale;

import id.com.anisatrilestari.customer.Customer;
import id.com.anisatrilestari.customer.CustomerRepository;
import id.com.anisatrilestari.product.Product;
import id.com.anisatrilestari.product.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

// Layanan yang menangani logika bisnis untuk entitas penjualan
@Service
public class SaleService {

    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;

    // Konstruktor untuk menginisialisasi SaleRepository, ProductRepository, dan CustomerRepository
    public SaleService(SaleRepository saleRepository, ProductRepository productRepository, CustomerRepository customerRepository) {
        this.saleRepository = saleRepository;
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
    }

    // Membuat penjualan baru
    @Transactional
    public Sale createSale(CreateSaleRequest request) {
        // Mencari customer berdasarkan ID
        Customer customer = customerRepository.findById(request.customerId())
                .orElseThrow(() -> new EntityNotFoundException("Customer tidak ditemukan dengan id " + request.customerId()));

        // Mencari semua produk berdasarkan ID yang diberikan
        List<Product> products = productRepository.findAllById(request.products());

        // Membuat entitas Sale baru dengan informasi yang diterima
        Sale sale = Sale.builder()
                .customer(customer) // Menetapkan customer
                .products(products) // Menetapkan produk yang dibeli
                .totalPrice(calculateTotalPrice(products)) // Menghitung total harga
                .dateOfSale(LocalDateTime.now()) // Mengatur tanggal penjualan
                .build();

        // Menyimpan data penjualan ke dalam database
        return saleRepository.save(sale);
    }

    // Mengambil penjualan berdasarkan ID
    public Sale getSaleById(Long id) {
        return saleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Sale tidak ditemukan dengan id " + id));
    }

    // Menghapus penjualan berdasarkan ID
    @Transactional
    public void deleteSale(Long id) {
        Sale sale = saleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Sale tidak ditemukan dengan id " + id));
        saleRepository.delete(sale); // Menghapus entitas penjualan
    }

    // Menghitung total harga dari produk yang dibeli
    private BigDecimal calculateTotalPrice(List<Product> products) {
        return products.stream()
                .map(Product::getPrice) // Mendapatkan harga masing-masing produk
                .reduce(BigDecimal.ZERO, BigDecimal::add); // Menjumlahkan harga produk
    }
}
