package org.finalproject.onlinestore.payload.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryUpdateRequest extends CategoryRequest {

    private long id;
    @JsonCreator
    public CategoryUpdateRequest(@JsonProperty("name") String name, @JsonProperty("id") long id) {
        super(name);
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
