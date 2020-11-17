package org.finalproject.onlinestore.payload.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.finalproject.onlinestore.entity.Category;

import javax.validation.Valid;

public class SubcategoryCreateRequest extends CategoryRequest {

    private final @Valid int parentId;

    @JsonCreator
    public SubcategoryCreateRequest(@JsonProperty("name") String name,
                                    @JsonProperty("parentId") int parentId) {
        super(name);
        this.parentId = parentId;
    }

    public int getParentId() {
        return parentId;
    }
}
