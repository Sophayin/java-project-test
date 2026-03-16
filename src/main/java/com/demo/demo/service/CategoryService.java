package com.demo.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.demo.entity.Category;
import com.demo.demo.repository.CategoryRepository;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // CREATE
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    // GET ALL
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    // GET BY ID
    public Category getById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    // UPDATE
    public Category update(Long id, Category category) {
        Category existing = categoryRepository.findById(id).orElse(null);

        if (existing != null) {
            existing.setName(category.getName());
            existing.setType(category.getType());
            existing.setDescription(category.getDescription());
            return categoryRepository.save(existing);
        }
        return null;
    }

    // DELETE
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}