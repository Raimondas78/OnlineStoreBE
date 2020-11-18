package org.finalproject.onlinestore.payload.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;

public class SubcategoryCreateRequest extends CategoryRequest {

    private final @Valid long parentId;

    @JsonCreator
    public SubcategoryCreateRequest(@JsonProperty("name") String name,
                                    @JsonProperty("parent_id") long parentId) {
        super(name);
        this.parentId = parentId;
    }

    public long getParentId() {
        return parentId;
    }
}
