package org.finalproject.onlinestore.payload.request;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.finalproject.onlinestore.entity.Category;

import javax.validation.constraints.NotBlank;

public class CategoryRequest {
    @NotBlank(message = "Category name must be present")
    private final String name;


    @JsonCreator
    public CategoryRequest(@JsonProperty("name") String name) {
        this.name = name;
    }

    public Category asCategory(){
        return new Category(name);
    }

    public String getName() {
        return name;
    }

}
