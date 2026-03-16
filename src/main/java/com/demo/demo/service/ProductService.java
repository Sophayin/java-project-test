
package com.demo.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.demo.entity.Product;
import com.demo.demo.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // CREATE
    public Product create(Product product) {
        Product lastProduct = productRepository.findTopByOrderByIdDesc();
        String newCode;
        if (lastProduct == null) {
            newCode = "PRD0001";
        } else {
            String lastCode = lastProduct.getCode();
            int number = Integer.parseInt(lastCode.substring(3));
            number++;
            newCode = String.format("PRD%04d", number);
        }

        product.setCode(newCode);
        product.setCreatedAt(LocalDateTime.now());
        return productRepository.save(product);
    }

    // READ ALL
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    // READ ONE
    public Product getById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    // UPDATE
    public Product update(Long id, Product newProduct) {
        Product product = getById(id);

        product.setTitle(newProduct.getTitle());
        product.setTitleTranslate(newProduct.getTitleTranslate());
        product.setPrice(newProduct.getPrice());
        product.setDiscount(newProduct.getDiscount());
        product.setDescription(newProduct.getDescription());

        return productRepository.save(product);
    }

    // DELETE
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}