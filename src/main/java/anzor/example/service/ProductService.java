package anzor.example.service;

import anzor.example.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();
    Product save(Product product);

    Product findByIdProduct(Long id);
    void deleteByIdProduct(Long id);


}
