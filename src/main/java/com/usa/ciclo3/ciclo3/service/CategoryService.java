package com.usa.ciclo3.ciclo3.service;


import com.usa.ciclo3.ciclo3.model.Category;
import com.usa.ciclo3.ciclo3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id) {
        return categoryRepository.getCategory(id);
    }

    public Category save(Category cs) {
        if (cs.getId() == null) {
            return categoryRepository.save(cs);
        } else {
            Optional<Category> categoryAuxiliar = categoryRepository.getCategory(cs.getId());
            if (categoryAuxiliar.isEmpty()) {
                return categoryRepository.save(cs);
            } else {
                return cs;
            }
        }
    }
}
