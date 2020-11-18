package org.finalproject.onlinestore.payload.response;

import org.finalproject.onlinestore.entity.Category;


public class ParentCategoryResponse {

    private final long id;
    private final String name;

    public ParentCategoryResponse(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static ParentCategoryResponse fromCategory(Category category){
        return new ParentCategoryResponse(
                category.getId(), category.getName());
    }



    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

//    public Set<SubcategoryResponse> getSubcategorySet() {
//        return subcategorySet;
//    }
}
