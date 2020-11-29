package org.finalproject.onlinestore.payload.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.finalproject.onlinestore.entity.Category;
import java.util.List;
import java.util.stream.Collectors;


public class ParentCategoryResponse {

    private final long id;
    private final String name;
    private List<SubcategoryPageResponse> subcategoryList;

    @JsonCreator
    public ParentCategoryResponse(@JsonProperty("id") long id,
                                  @JsonProperty("name") String name,
                                  @JsonProperty("subcategoryList") List<SubcategoryPageResponse> subcategoryList) {
        this.id = id;
        this.name = name;
        this.subcategoryList =subcategoryList;
    }

    public static ParentCategoryResponse fromCategory(Category category){
        List<SubcategoryPageResponse> subcategoryList = category.getSubCategories().
                stream().map(SubcategoryPageResponse::fromSubcategory).collect(Collectors.toList());
        return new ParentCategoryResponse(
                category.getId(), category.getName(), subcategoryList);
    }



    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<SubcategoryPageResponse> getSubcategoryList() {
        return subcategoryList;
    }
}
