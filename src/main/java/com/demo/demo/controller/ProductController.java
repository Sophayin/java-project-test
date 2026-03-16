package com.demo.demo.controller;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.demo.entity.Product;
import com.demo.demo.service.ExcelService;
import com.demo.demo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // CREATE
    @PostMapping("/create")
    public Product create(@RequestBody Product product) {
        return productService.create(product);
    }

    // READ ALL
    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    // READ ONE
    @GetMapping("/update/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {
        return productService.update(id, product);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

    // EXPORT EXCEL
    @GetMapping("/export/excel")
    public ResponseEntity<InputStreamResource> exportExcel() {
        List<Product> products = productService.getAll();
        ByteArrayInputStream in = ExcelService.exportProducts(products);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=products.xlsx");
        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new InputStreamResource(in));
    }
}