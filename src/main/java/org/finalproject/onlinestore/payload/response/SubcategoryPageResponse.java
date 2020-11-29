package org.finalproject.onlinestore.payload.response;

import org.finalproject.onlinestore.entity.Category;
import org.finalproject.onlinestore.service.CategoryService;

public class SubcategoryPageResponse extends SubcategoryResponse {
    CategoryService categoryService;

    private final Category parentCategory;

    public SubcategoryPageResponse(long id, String name, Category parentCategory) {
        super(id, name);
        this.parentCategory = parentCategory;
    }

    public static SubcategoryPageResponse fromSubcategory (Category category){

        return new SubcategoryPageResponse(
                category.getId(),
                category.getName(),
                category.getParentCategory());
    }

}
