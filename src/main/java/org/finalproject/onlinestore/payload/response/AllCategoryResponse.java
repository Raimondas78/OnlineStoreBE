package org.finalproject.onlinestore.payload.response;

import org.finalproject.onlinestore.entity.Category;

import java.util.Set;
import java.util.stream.Collectors;

public class AllCategoryResponse {


    private final long id;
    private final String name;


    public AllCategoryResponse(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static AllCategoryResponse allCategory(Category category) {

//        Set<SubcategoryResponse> subcategorySet =
//                category.getSubCategories().
//                        stream().
//                        map(SubcategoryResponse::fromSubcategory).
//                        collect(Collectors.toSet());

        return new AllCategoryResponse(
                category.getId(), category.getName());
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}


