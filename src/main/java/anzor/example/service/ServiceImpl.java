package anzor.example.service;

import anzor.example.entity.Product;
import anzor.example.exception.EntityNotFoundException;
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


    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(String.format("Product with id %s not found",
                        id)));
    }

    public void deleteById(Long id) {

       productRepository.deleteById(id);
    }
}
