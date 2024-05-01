package com.minutes.restfulwebservices.app.resource;

import com.minutes.restfulwebservices.app.dto.request.UserSaveRequest;
import com.minutes.restfulwebservices.app.dto.response.PostResponse;
import com.minutes.restfulwebservices.app.dto.response.UserResponse;
import com.minutes.restfulwebservices.app.service.IPostService;
import com.minutes.restfulwebservices.app.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private IUserService service;

    @GetMapping(path = "/users")
    public List<UserResponse> getAllUsers() {
        return service.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public EntityModel<UserResponse> getUser(@PathVariable Integer id) {
        return service.findOne(id);
    }

    @PostMapping(path = "/users")
    public ResponseEntity<UserResponse> createUser(@RequestBody @Valid UserSaveRequest request) {
        return service.save(request);
    }

    @DeleteMapping(path = "/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        return service.deleteById(id);
    }

}
