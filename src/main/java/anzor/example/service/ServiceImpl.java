package anzor.example.service;

import anzor.example.entity.Product;
import anzor.example.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    @Override
    public List<Product> findAll() {

        return productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findByIdProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteByIdProduct(Long id) {


       productRepository.delete(findByIdProduct(id));
    }
}
