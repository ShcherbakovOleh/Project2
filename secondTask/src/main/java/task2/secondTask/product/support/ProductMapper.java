package task2.secondTask.product.support;

import org.springframework.stereotype.Component;
import task2.secondTask.product.api.request.ProductRequest;
import task2.secondTask.product.api.response.ProductResponse;
import task2.secondTask.product.domain.Product;

@Component
public class ProductMapper {

    public Product toProduct(ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        return product;
    }

    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(product.getId(), product.getName());
    }
}
