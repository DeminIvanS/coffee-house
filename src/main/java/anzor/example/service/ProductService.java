package anzor.example.service;

import anzor.example.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();
    Product save(Product product);

    Product findById(Long id);
    void deleteById(Long id);


}
