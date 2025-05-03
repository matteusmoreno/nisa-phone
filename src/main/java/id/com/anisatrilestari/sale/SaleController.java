package id.com.anisatrilestari.sale;

import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/sales")
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping("/create")
    public ResponseEntity<SaleDetailsResponse> createSale(@RequestBody @Valid CreateSaleRequest request, UriComponentsBuilder uriBuilder) {
        Sale sale = saleService.createSale(request);
        URI uri = uriBuilder.path("/sales/{id}").buildAndExpand(sale.getId()).toUri();

        return ResponseEntity.created(uri).body(new SaleDetailsResponse(sale));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleDetailsResponse> getSale(@PathVariable Long id) {
        Sale sale = saleService.getSaleById(id);
        return ResponseEntity.ok(new SaleDetailsResponse(sale));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSale(@PathVariable Long id) {
        saleService.deleteSale(id);
        return ResponseEntity.noContent().build();
    }
}
