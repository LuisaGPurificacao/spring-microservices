package com.minutes.restfulwebservices.domain.usecase.impl;

import com.minutes.restfulwebservices.cross.exception.UserNotFoundException;
import com.minutes.restfulwebservices.domain.entity.UserEntity;
import com.minutes.restfulwebservices.domain.usecase.IUserUseCase;
import com.minutes.restfulwebservices.infra.dataprovider.UserDataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class UserUseCase implements IUserUseCase {

    @Autowired
    private UserDataProvider dataProvider;

    public List<UserEntity> findAll() {
        return dataProvider.findAll();
    }

    public UserEntity save(UserEntity user) {
        return dataProvider.save(user);
    }

    public UserEntity findOne(Integer id) {
        UserEntity user = dataProvider.findById(id);
        if (Objects.isNull(user))
            throw new UserNotFoundException(id);
        return user;
    }

    public void deleteById(Integer id) {
        dataProvider.deleteById(id);
    }

}
