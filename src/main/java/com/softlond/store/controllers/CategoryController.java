package com.softlond.store.controllers;

import com.softlond.store.entities.Category;
import com.softlond.store.services.contracts.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/list")
    private ResponseEntity<List<Category>> getAllCategories() {
        return this.categoryService.findAll();
    }

    @PostMapping("/create")
    private  ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return this.categoryService.create(category);
    }

    @PutMapping("/update")
    private ResponseEntity<Category> updateCategory(@RequestBody Category category) {
        return this.categoryService.update(category);
    }

    @DeleteMapping("/delete")
    private ResponseEntity<Boolean> deleteCategory(@RequestParam Long id) {
        return this.categoryService.delete(id);
    }
}
