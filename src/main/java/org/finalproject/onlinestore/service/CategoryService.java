package org.finalproject.onlinestore.service;

import org.finalproject.onlinestore.entity.Category;
import org.finalproject.onlinestore.payload.request.ParentCategoryCreateRequest;
import org.finalproject.onlinestore.payload.request.CategoryUpdateRequest;
import org.finalproject.onlinestore.payload.request.SubcategoryCreateRequest;
import org.finalproject.onlinestore.payload.response.AllCategoryResponse;
import org.finalproject.onlinestore.payload.response.ParentCategoryResponse;
import org.finalproject.onlinestore.payload.response.SubcategoryResponse;
import org.finalproject.onlinestore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<AllCategoryResponse> findAll() {
        return categoryRepository.findAll().
                stream().map(c -> AllCategoryResponse.allCategory(c)).
                collect(Collectors.toList());
    }

    public List<ParentCategoryResponse> findALlParents() {
        return categoryRepository.getParentCategories().stream().
                map(ParentCategoryResponse::fromCategory).
                collect(Collectors.toList());
    }

    public List<SubcategoryResponse> findALlSubcategories(long id) {
        return categoryRepository.findAllById(id).stream().
                map(SubcategoryResponse::fromSubcategory).
                collect(Collectors.toList());
    }
    @Transactional
    public void addParentCategory(ParentCategoryCreateRequest parentCategoryCreateRequest) {
        Category parentCategory = parentCategoryCreateRequest.asCategory();
        categoryRepository.save(parentCategory);
    }
    @Transactional
    public void addSubcategory(SubcategoryCreateRequest subcategoryCreateRequest){
        Category subcategory = subcategoryCreateRequest.asCategory();
        categoryRepository.save(subcategory);
        Category  retrievedSubcategory = categoryRepository.findCategoryByName(subcategory.getName());
        long id = retrievedSubcategory.getId();
        long parentId = subcategoryCreateRequest.getParentId();
        categoryRepository.updateSubcategoryByParentId(parentId,id);
    }

    @Transactional
    public void updateCategory(final CategoryUpdateRequest categoryUpdateRequest){
        categoryRepository.updateCategoryInfoById(
                categoryUpdateRequest.getName(),
                categoryUpdateRequest.getId());
    }

    @Transactional
    public void delete(Category category) {
        categoryRepository.deleteById((long)category.getId());
    }

    public Optional<Category> findById(long id) {
        return categoryRepository.findById(id);
    }

}
