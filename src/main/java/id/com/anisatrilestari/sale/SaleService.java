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

@Service
public class SaleService {

    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;


    public SaleService(SaleRepository saleRepository, ProductRepository productRepository, CustomerRepository customerRepository) {
        this.saleRepository = saleRepository;
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
    }

    @Transactional
    public Sale createSale(CreateSaleRequest request) {
        Customer customer = customerRepository.findById(request.customerId())
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id " + request.customerId()));

        List<Product> products = productRepository.findAllById(request.products());
        Sale sale = Sale.builder()
                .customer(customer)
                .products(products)
                .totalPrice(calculateTotalPrice(products))
                .dateOfSale(LocalDateTime.now())
                .build();
        return saleRepository.save(sale);
    }

    public Sale getSaleById(Long id) {
        return saleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Sale not found with id " + id));
    }

    @Transactional
    public void deleteSale(Long id) {
        Sale sale = saleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Sale not found with id " + id));
        saleRepository.delete(sale);
    }

    private BigDecimal calculateTotalPrice(List<Product> products) {
        return products.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
