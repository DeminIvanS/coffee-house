package aiven_s.example.service;

import aiven_s.example.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();
    Product save(Product product);

    Product findById(Long id);
    void deleteById(Long id);


}
