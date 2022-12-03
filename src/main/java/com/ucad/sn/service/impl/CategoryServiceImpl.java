package com.ucad.sn.service.impl;

import com.ucad.sn.domain.Category;
import com.ucad.sn.repository.CategoryRepository;
import com.ucad.sn.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private  final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category findById(Long id) {
        if(id == null)
        {
            log.error("Category not found");
        }
        return categoryRepository.findById(id).get();
    }

    @Override
    public Category update(Long id, Category category) {
        if(id == null){
            log.error("Category not found");
            return null;
        }
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
       categoryRepository.deleteById(id);
    }
}
