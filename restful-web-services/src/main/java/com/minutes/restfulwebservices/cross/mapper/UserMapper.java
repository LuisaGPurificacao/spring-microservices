package com.minutes.restfulwebservices.cross.mapper;

import com.minutes.restfulwebservices.app.dto.request.UserSaveRequest;
import com.minutes.restfulwebservices.app.dto.response.UserResponse;
import com.minutes.restfulwebservices.domain.entity.UserEntity;
import com.minutes.restfulwebservices.infra.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    UserEntity toEntity(UserSaveRequest request);

    UserResponse toResponse(UserEntity entity);

    List<UserResponse> toResponse(List<UserEntity> entities);

    UserEntity toEntity(User model);

    List<UserEntity> toEntity(List<User> model);

    User toModel(UserEntity entity);

}
