package com.minutes.restfulwebservices.app.service;

import com.minutes.restfulwebservices.app.dto.request.UserSaveRequest;
import com.minutes.restfulwebservices.app.dto.response.UserResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserService {

    List<UserResponse> findAll();

    ResponseEntity<UserResponse> save(UserSaveRequest request);

    UserResponse findOne(Integer id);

    ResponseEntity<Void> deleteById(Integer id);

}
