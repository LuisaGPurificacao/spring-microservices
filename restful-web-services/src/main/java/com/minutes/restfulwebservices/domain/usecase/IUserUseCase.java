package com.minutes.restfulwebservices.domain.usecase;

import com.minutes.restfulwebservices.domain.entity.UserEntity;

import java.util.List;

public interface IUserUseCase {

    List<UserEntity> findAll();

    UserEntity save(UserEntity user);

    UserEntity findOne(Integer id);

    void deleteById(Integer id);

}
