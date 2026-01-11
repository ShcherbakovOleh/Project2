package task2.secondTask.product.support;

import org.springframework.stereotype.Component;
import task2.secondTask.product.support.exception.ProductNotFoundException;
import java.util.function.Supplier;

@Component
public class ProductExceptionSupplier {

    public Supplier<ProductNotFoundException> productNotFound(Long id) {
        return () -> new ProductNotFoundException(id);
    }
}
