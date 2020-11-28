package org.finalproject.onlinestore.payload.response;

import org.finalproject.onlinestore.entity.Category;

import java.util.ArrayList;
import java.util.List;


public class ParentCategoryResponse {

    private final long id;
    private final String name;
    private static final List<SubcategoryResponse> subcategoryList = new ArrayList<>();

    public ParentCategoryResponse(long id, String name, List<SubcategoryResponse> subcategoryList) {
        this.id = id;
        this.name = name;
    }

    public static ParentCategoryResponse fromCategory(Category category){
        return new ParentCategoryResponse(
                category.getId(), category.getName(), subcategoryList);
    }



    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<SubcategoryResponse> getSubcategoryList() {
        return subcategoryList;
    }
}
