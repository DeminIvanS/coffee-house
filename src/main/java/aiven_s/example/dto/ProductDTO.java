package aiven_s.example.dto;

import aiven_s.example.entity.Product;


public record ProductDTO(Long id, String name, String description) {

    public static ProductDTO fromProduct(Product product) {
        return new ProductDTO(product.getId(), product.getName(), product.getDescription());
    }

    public Product toProduct(){
        return new Product(id, name, description);
    }



}
