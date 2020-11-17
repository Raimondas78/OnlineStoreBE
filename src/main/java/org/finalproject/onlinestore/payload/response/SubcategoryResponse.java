package org.finalproject.onlinestore.payload.response;

import org.finalproject.onlinestore.entity.Category;

public class SubcategoryResponse {

    private final long id;
    private final String name;

    public SubcategoryResponse(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static SubcategoryResponse fromSubcategory(Category category){
        return new SubcategoryResponse(
                category.getId(),
                category.getName());
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
