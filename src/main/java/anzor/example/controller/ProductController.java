package anzor.example.controller;


import anzor.example.dto.ProductDTO;
import anzor.example.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import anzor.example.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/v1/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService service;


    @GetMapping("")
    public String listProducts(Model model) {
        List<ProductDTO> productsList = service.findAll()
                .stream()
                .map(ProductDTO::fromProduct)
                .toList();
        model.addAttribute("products", productsList);
        return "product/list";
    }
    @GetMapping("/new")
    public String formProduct(Model model) {
        model.addAttribute("product", ProductDTO.fromProduct(new Product()));
        return "product/form";
    }
    @GetMapping("/{id}")
    public String editProduct(@PathVariable Long id, Model model) {
        ProductDTO productDTO = ProductDTO.fromProduct(service.findById(id));
        model.addAttribute("product", productDTO);

        return "product/form";
    }
    @GetMapping("/{id}/delete")
    public String deleteProduct(@PathVariable Long id) {
        service.deleteById(id);

        return "redirect:/api/v1/product";
    }
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute ProductDTO productDTO) {

        service.save(productDTO.toProduct());

        return "redirect:/api/v1/product";
    }

}
