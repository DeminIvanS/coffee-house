package anzor.example;

import anzor.example.entity.Product;
import anzor.example.service.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class CafeApp implements CommandLineRunner {
    private final ServiceImpl serviceImpl;
    public static void main(String[] args) {
        SpringApplication.run(CafeApp.class, args);

    }
    @Override
    public void run(String... args) throws Exception {
        Product product = new Product();
        product.setName("Nescafe");
        product.setDescription("soluble");

        serviceImpl.save(product);

        Product product2 = new Product();
        product2.setName("Jacobs");
        product2.setDescription("soluble");
        serviceImpl.save(product2);
        System.out.println(serviceImpl.findAll());

        Long productId = product2.getId();
        Product editedProduct = serviceImpl.findByIdProduct(productId);
        editedProduct.setDescription("finished");
        serviceImpl.save(editedProduct);
        System.out.println(serviceImpl.findAll());

        serviceImpl.deleteByIdProduct(productId);
        System.out.println(serviceImpl.findAll());
    }
}