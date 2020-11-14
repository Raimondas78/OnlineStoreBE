package org.finalproject.onlinestore.payload.response;

import org.finalproject.onlinestore.entity.Category;

public class SubcategoryResponse {

    private final long id;
    private final String name;
    private final long parentId;

    public SubcategoryResponse(long id, String name, long parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }

    public static SubcategoryResponse fromSubcategory(Category category){
        return new SubcategoryResponse(
                category.getId(),
                category.getName(),
                category.getParentCategory().getId());
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
