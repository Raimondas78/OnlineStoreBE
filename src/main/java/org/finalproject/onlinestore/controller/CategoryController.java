package org.finalproject.onlinestore.controller;
import org.finalproject.onlinestore.entity.Category;
import org.finalproject.onlinestore.exception.NotFoundException;
import org.finalproject.onlinestore.payload.request.CategoryUpdateRequest;
import org.finalproject.onlinestore.payload.request.ParentCategoryCreateRequest;
import org.finalproject.onlinestore.payload.request.SubcategoryCreateRequest;
import org.finalproject.onlinestore.payload.response.AllCategoryResponse;
import org.finalproject.onlinestore.payload.response.ParentCategoryResponse;
import org.finalproject.onlinestore.payload.response.SubcategoryResponse;
import org.finalproject.onlinestore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

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

    @GetMapping("/parentcategory/{id}")
    public ParentCategoryResponse getParentById(@PathVariable("id") Long id) {
        return categoryService.getParentById(id);
    }

    @GetMapping("/categories/{id}")
    public List<SubcategoryResponse> getAllSubcategories(@PathVariable("id") long id) {
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

    @PutMapping("/categories")
    public void updateCategory(@RequestBody @Valid CategoryUpdateRequest categoryUpdateRequest){
        categoryService.updateCategory(categoryUpdateRequest);
    }

    @DeleteMapping("/categories/{id}")
    public void delete(@PathVariable("id") long id){
        Category category = categoryService.findById(id).orElseThrow(() ->new NotFoundException("id:" +id));
        categoryService.delete(category);
    }
}
