package id.com.anisatrilestari.product;

import id.com.anisatrilestari.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //CREATE PRODUCT
    @Transactional
    public Product createProducts(CreateProductRequest request) {

        Product product = Product.builder()
                .name(request.name())
                .price(request.price())
                .build();

        productRepository.save(product);
        return product;
    }

    //GET PRODUCT BY ID
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    @Transactional
    public Product updateProducts(UpdateProductRequest request) {
        Product product = productRepository.findById(request.id()).orElseThrow(() -> new RuntimeException("Product not found with id: " + request.id()));
        if (request.name() != null) {
            product.setName(request.name());
        }
        if (request.price() != null) {
            product.setPrice(request.price());
        }

        productRepository.save(product);
        return product;
    }

    @Transactional
    public void deleteProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        productRepository.delete(product);
    }
}