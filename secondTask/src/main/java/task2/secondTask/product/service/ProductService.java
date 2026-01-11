package task2.secondTask.product.service;

import org.springframework.stereotype.Service;
import task2.secondTask.product.api.request.ProductRequest;
import task2.secondTask.product.api.response.ProductResponse;
import task2.secondTask.product.domain.Product;
import task2.secondTask.product.repository.ProductRepository;
import task2.secondTask.product.support.ProductExceptionSupplier;
import task2.secondTask.product.support.ProductMapper;
import task2.secondTask.product.support.exception.ProductNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final List<Product> products = new ArrayList<>();

    private long nextId = 1;

    private final ProductExceptionSupplier exceptionSupplier;

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    public ProductService(ProductRepository productRepository,
                          ProductMapper productMapper,
                          ProductExceptionSupplier exceptionSupplier) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.exceptionSupplier = exceptionSupplier;
    }


    public ProductResponse create(ProductRequest request) {
        Product product = productMapper.toProduct(request);
        Product savedProduct = productRepository.save(product);
        return productMapper.toProductResponse(savedProduct);
    }

    public ProductResponse find(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(exceptionSupplier.productNotFound(id));
        return productMapper.toProductResponse(product);
    }

    public ProductResponse update(Long id, ProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(exceptionSupplier.productNotFound(id));
        product.setName(request.getName());
        Product updatedProduct = productRepository.save(product);
        return productMapper.toProductResponse(updatedProduct);
    }


    public Product findById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    public void delete(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(exceptionSupplier.productNotFound(id));
        productRepository.deleteById(product.getId());

    }

    public List<ProductResponse> findAll() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toProductResponse)
                .toList();
    }


}
