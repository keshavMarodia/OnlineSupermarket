package com.OOPSg22.major.service;

import com.OOPSg22.major.model.Category;
import com.OOPSg22.major.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    public void addCategory(Category category)
    {
        categoryRepository.save(category);
    }
    public List<Category> getAllCategory()
    {
        return categoryRepository.findAll();
    }
    public void removerCategoryById(int id)
    {
        categoryRepository.deleteById(id);
    }

    public Optional<Category> getCategoryById(int id)
    {
        return categoryRepository.findById(id);
    }
}
