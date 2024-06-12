package aiven_s.example.service;

import aiven_s.example.entity.Product;
import aiven_s.example.exception.EntityNotFoundException;
import aiven_s.example.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    @Override
    public List<Product> findAll() {

        return productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }


    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(String.format("Product with id %s not found",
                        id)));
    }

    public void deleteById(Long id) {

       productRepository.deleteById(id);
    }
}
