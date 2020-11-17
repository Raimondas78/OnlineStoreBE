package org.finalproject.onlinestore.controller;
import org.finalproject.onlinestore.payload.request.ParentCategoryCreateRequest;
import org.finalproject.onlinestore.payload.request.SubcategoryCreateRequest;
import org.finalproject.onlinestore.payload.response.AllCategoryResponse;
import org.finalproject.onlinestore.payload.response.ParentCategoryResponse;
import org.finalproject.onlinestore.payload.response.SubcategoryResponse;
import org.finalproject.onlinestore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public List<ParentCategoryResponse> getAllParents() {
        return categoryService.findALlParents();
    }

    @GetMapping("/allcategories")
    public List<AllCategoryResponse> getAll() {
        return categoryService.findAll();
    }

    @GetMapping("/categories/{id}")
    public List<SubcategoryResponse> getAll(@PathVariable("id") int id) {
        return categoryService.findALlSubcategories(id);
    }

    @PostMapping("/categories")
    public void addCategory(@RequestBody @Valid ParentCategoryCreateRequest parentCategory) {
        categoryService.addParentCategory(parentCategory);
    }

    @PostMapping("/subcategory")
    public void addSubcategory(@RequestBody @Valid SubcategoryCreateRequest subcategoryCreateRequest){
        categoryService.addSubcategory(subcategoryCreateRequest);
    }
}
