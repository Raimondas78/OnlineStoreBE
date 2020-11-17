package org.finalproject.onlinestore.payload.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class ParentCategoryCreateRequest extends CategoryRequest {


        @JsonCreator
        public ParentCategoryCreateRequest(@JsonProperty("name") String name) {
            super(name);
        }


}
