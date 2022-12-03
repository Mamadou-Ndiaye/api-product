package com.ucad.sn.web;

import com.ucad.sn.domain.Category;
import com.ucad.sn.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping(value = "/api/categories", produces = MediaType.APPLICATION_JSON_VALUE )
public class CategoryResource {
    private  final CategoryService categoryService;

    public CategoryResource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable final Long id) {
        return ResponseEntity.ok(categoryService.findById(id));
    }


    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody final Category category) {
        return new ResponseEntity<>(categoryService.save(category), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCategory(@PathVariable final Long id,
                                              @RequestBody  final Category category) {
        categoryService.update(id, category);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable final Long id) {
        categoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
