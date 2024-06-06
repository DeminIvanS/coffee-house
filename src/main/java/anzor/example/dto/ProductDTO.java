package anzor.example.dto;

import anzor.example.entity.Product;
import lombok.Getter;
import lombok.Setter;


public record ProductDTO(Long id, String name, String description) {

    public static ProductDTO fromProduct(Product product) {
        return new ProductDTO(product.getId(), product.getName(), product.getDescription());
    }

    public Product toProduct(){
        return new Product(id, name, description);
    }



}
