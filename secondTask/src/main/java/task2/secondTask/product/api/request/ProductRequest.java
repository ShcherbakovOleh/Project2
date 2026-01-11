package task2.secondTask.product.api.request;

public class ProductRequest {

    private String name;


    public ProductRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
