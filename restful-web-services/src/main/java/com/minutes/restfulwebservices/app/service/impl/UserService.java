package com.minutes.restfulwebservices.app.service.impl;

import com.minutes.restfulwebservices.app.dto.request.UserSaveRequest;
import com.minutes.restfulwebservices.app.dto.response.UserResponse;
import com.minutes.restfulwebservices.app.resource.UserResource;
import com.minutes.restfulwebservices.app.service.IUserService;
import com.minutes.restfulwebservices.cross.mapper.UserMapper;
import com.minutes.restfulwebservices.domain.usecase.impl.UserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserUseCase useCase;

    @Autowired
    private UserMapper mapper;

    public List<UserResponse> findAll() {
        return mapper.toResponse(useCase.findAll());
    }

    public ResponseEntity<UserResponse> save(UserSaveRequest request) {
        UserResponse response = mapper.toResponse(useCase.save(mapper.toEntity(request)));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .build(response.getId());
        return ResponseEntity.created(location).body(response);
    }

    public EntityModel<UserResponse> findOne(Integer id) {
        EntityModel<UserResponse> response = EntityModel.of(mapper.toResponse(useCase.findOne(id)));
        WebMvcLinkBuilder link = linkTo(methodOn(UserResource.class).getAllUsers());
        response.add(link.withRel("all-users"));
        return response;
    }

    public ResponseEntity<Void> deleteById(Integer id) {
        useCase.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
