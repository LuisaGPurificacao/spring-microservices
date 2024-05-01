package com.minutes.restfulwebservices.app.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserSaveRequest {

    @Size(min = 2, message = "the name must have more than 2 characters")
    private String name;

    @Past(message = "the birth date must be in the past")
    private LocalDate birthDate;

}
