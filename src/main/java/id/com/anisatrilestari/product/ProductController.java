package id.com.anisatrilestari.product;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

// Controller REST untuk menangani permintaan terkait produk
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Endpoint untuk membuat produk baru
    @PostMapping("/create")
    public ResponseEntity<ProductDetailsResponse> create(@RequestBody @Valid CreateProductRequest request, UriComponentsBuilder uriBuilder) {
        Product product = productService.createProducts(request);
        URI uri = uriBuilder.path("/products/create/{id}").buildAndExpand(product.getId()).toUri();

        return ResponseEntity.created(uri).body(new ProductDetailsResponse(product));
    }

    // Endpoint untuk mengambil detail produk berdasarkan ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductDetailsResponse> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(new ProductDetailsResponse(product));
    }

    // Endpoint untuk memperbarui data produk
    @PutMapping("/update")
    public ResponseEntity<ProductDetailsResponse> update(@RequestBody @Valid UpdateProductRequest request) {
        Product product = productService.updateProducts(request);
        return ResponseEntity.ok(new ProductDetailsResponse(product));
    }

    // Endpoint untuk menghapus produk berdasarkan ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.deleteProductById(id);
        return ResponseEntity.noContent().build(); // Tidak mengembalikan konten
    }
}
