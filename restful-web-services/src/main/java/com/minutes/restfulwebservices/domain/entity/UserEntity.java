package com.minutes.restfulwebservices.domain.entity;

import com.minutes.restfulwebservices.infra.model.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    private Integer id;
    private String name;
    private LocalDate birthDate;
    private List<Post> posts;

}
