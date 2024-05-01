package com.minutes.restfulwebservices.app.dto.response;

import com.minutes.restfulwebservices.infra.model.Post;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class PostResponse {

    private Integer id;
    private String description;

}
