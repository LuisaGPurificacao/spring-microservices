package com.minutes.restfulwebservices.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostEntity {

    private Integer id;
    private String description;
    private UserEntity user;

}
