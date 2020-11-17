package org.finalproject.onlinestore.payload.response;

import org.finalproject.onlinestore.entity.Category;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ParentCategoryResponse {

    private final long id;
    private final String name;
  //  private final Set<SubcategoryResponse> subcategorySet;

    public ParentCategoryResponse(long id, String name) {
        this.id = id;
        this.name = name;
        //this.subcategorySet = subcategorySet;
    }

    public static ParentCategoryResponse fromCategory(Category category){


//        Set<SubcategoryResponse> subcategorySet =
//                category.getSubCategories().
//                        stream().
//                        map(SubcategoryResponse::fromSubcategory).
//                        collect(Collectors.toSet());

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
