package com.minutes.restfulwebservices.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    private Integer id;
    private String name;
    private LocalDate birthDate;

}
