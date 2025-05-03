package id.com.anisatrilestari.sale;

import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

// Kontroler REST untuk menangani operasi yang berkaitan dengan penjualan
@RestController
@RequestMapping("/sales")
public class SaleController {

    private final SaleService saleService;

    // Konstruktor untuk menginisialisasi SaleService
    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    // Endpoint untuk membuat penjualan baru
    @PostMapping("/create")
    public ResponseEntity<SaleDetailsResponse> createSale(@RequestBody @Valid CreateSaleRequest request, UriComponentsBuilder uriBuilder) {
        // Membuat penjualan dan menyimpan informasi penjualan
        Sale sale = saleService.createSale(request);
        // Membuat URI untuk penjualan yang baru saja dibuat
        URI uri = uriBuilder.path("/sales/{id}").buildAndExpand(sale.getId()).toUri();

        // Mengembalikan respon dengan status 201 dan detail penjualan
        return ResponseEntity.created(uri).body(new SaleDetailsResponse(sale));
    }

    // Endpoint untuk mengambil detail penjualan berdasarkan ID
    @GetMapping("/{id}")
    public ResponseEntity<SaleDetailsResponse> getSale(@PathVariable Long id) {
        // Mengambil data penjualan berdasarkan ID
        Sale sale = saleService.getSaleById(id);
        return ResponseEntity.ok(new SaleDetailsResponse(sale)); // Mengembalikan detail penjualan
    }

    // Endpoint untuk menghapus penjualan berdasarkan ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSale(@PathVariable Long id) {
        // Menghapus penjualan berdasarkan ID
        saleService.deleteSale(id);
        return ResponseEntity.noContent().build(); // Mengembalikan status no content (berhasil menghapus)
    }
}
