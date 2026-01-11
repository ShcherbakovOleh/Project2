package task2.secondTask.product.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import task2.secondTask.product.api.request.ProductRequest;
import task2.secondTask.product.api.response.ProductResponse;
import task2.secondTask.product.domain.Product;
import task2.secondTask.product.service.ProductService;
import java.util.List;


@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> create(
            @RequestBody ProductRequest request
    ) {
        ProductResponse response = productService.create(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> find(@PathVariable Long id) {
        ProductResponse response = productService.find(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(
            @PathVariable Long id,
            @RequestBody ProductRequest request) {
        return ResponseEntity.ok(productService.update(id, request));
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

}
