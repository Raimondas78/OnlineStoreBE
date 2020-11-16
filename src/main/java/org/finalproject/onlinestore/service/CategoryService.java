package org.finalproject.onlinestore.service;

import org.finalproject.onlinestore.entity.Category;
import org.finalproject.onlinestore.payload.response.ParentCategoryResponse;
import org.finalproject.onlinestore.payload.response.SubcategoryResponse;
import org.finalproject.onlinestore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<ParentCategoryResponse> findAll(){
        return categoryRepository.
                findAll().
                stream().
                map(c -> ParentCategoryResponse.fromCategory(c)).
                collect(Collectors.toList());
    }

    public List<ParentCategoryResponse> findALlParents(){
        return categoryRepository.getParentCategories().stream().map(ParentCategoryResponse::fromCategory).
                collect(Collectors.toList());
    }

    public List<SubcategoryResponse> findALlSubcategories(int id){
        return categoryRepository.findAllById(id).stream().map(SubcategoryResponse::fromSubcategory).collect(Collectors.toList());
    }

}
