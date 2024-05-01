package com.minutes.restfulwebservices.app.dto.request;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PostSaveRequest {

    @Size(min = 2, message = "the description must have more than 2 characters")
    private String description;

}
