package com.minutes.restfulwebservices.app.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserResponse {

    private Integer id;
    private String name;
    private LocalDate birthDate;

}
