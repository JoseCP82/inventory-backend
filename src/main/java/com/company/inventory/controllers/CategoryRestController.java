package com.company.inventory.controllers;

import com.company.inventory.model.Category;
import com.company.inventory.response.CategoryResponseRest;
import com.company.inventory.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CategoryRestController {

    @Autowired
    private ICategoryService service;

    /**
     * Get all categories
     * @return
     */
    @GetMapping("/categories")
    public ResponseEntity<CategoryResponseRest> searchCategories() {
        ResponseEntity<CategoryResponseRest> response = service.search();
        return response;
    }

    /**
     * Get categories by Id
     * @param id
     * @return
     */
    @GetMapping("/categories/{id}")
    public ResponseEntity<CategoryResponseRest> searchCategoriesById(@PathVariable Long id) {
        ResponseEntity<CategoryResponseRest> response = service.searchById(id);
        return response;
    }

    /**
     * Save categories
     * @param category
     * @return
     */
    @PostMapping("/categories")
    public ResponseEntity<CategoryResponseRest> saveCategories(@RequestBody Category category) {
        ResponseEntity<CategoryResponseRest> response = service.save(category);
        return response;
    }

    /**
     * Update category
     * @param category
     * @param id
     * @return
     */
    @PutMapping("/categories/{id}")
    public ResponseEntity<CategoryResponseRest> updateCategories(@RequestBody Category category, @PathVariable Long id) {
        ResponseEntity<CategoryResponseRest> response = service.update(category, id);
        return response;
    }

    /**
     * Delete category
     * @param id
     * @return
     */
    @DeleteMapping("/categories/{id}")
    public ResponseEntity<CategoryResponseRest> deleteCategories(@PathVariable Long id) {
        ResponseEntity<CategoryResponseRest> response = service.deleteById(id);
        return response;
    }
}
