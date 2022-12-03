package com.ucad.sn.service;

import com.ucad.sn.domain.Category;
import com.ucad.sn.domain.Product;

import java.util.List;

public interface CategoryService {

    Category save(Category category);

    Category findById(Long id);

    Category update(Long id ,Category category);

    List<Category> findAll();

    void  deleteById(Long id);

}
