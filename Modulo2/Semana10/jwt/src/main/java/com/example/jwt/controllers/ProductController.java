package com.example.jwt.controllers;

import com.example.jwt.controllers.dto.ProductDTO;
import com.example.jwt.model.Product;
import com.example.jwt.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> listProducts() {
        return productService.findAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<Product> listProduct(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping
    public Product addProduct(@RequestBody ProductDTO productDTO) {
        Product product = Product.builder()
                .name(productDTO.getName())
                .description(productDTO.getDescription())
                .price(productDTO.getPrice())
                .releaseDate(productDTO.getReleaseDate())
                .build();

        return productService.addProduct(product);
    }

    @PutMapping(path = "/{id}")
    public Product updateProduct(@RequestBody ProductDTO productDTO, @PathVariable Long id) {
        Product product = Product.builder()
                .id(id)
                .name(productDTO.getName())
                .description(productDTO.getDescription())
                .price(productDTO.getPrice())
                .releaseDate(productDTO.getReleaseDate())
                .build();

        return productService.updateProduct(product);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(id);
    }

}
