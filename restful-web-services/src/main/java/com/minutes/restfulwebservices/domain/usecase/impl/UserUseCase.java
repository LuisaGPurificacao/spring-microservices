package com.minutes.restfulwebservices.domain.usecase.impl;

import com.minutes.restfulwebservices.cross.exception.UserNotFoundException;
import com.minutes.restfulwebservices.domain.entity.UserEntity;
import com.minutes.restfulwebservices.domain.usecase.IUserUseCase;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserUseCase implements IUserUseCase {

    private static List<UserEntity> users = new ArrayList<>();

    static {
        users.add(new UserEntity(1, "Matheus", LocalDate.of(1995, 9, 4)));
        users.add(new UserEntity(2, "Luisa", LocalDate.of(2004, 9, 16)));
        users.add(new UserEntity(3, "Lívia", LocalDate.of(2003, 12, 16)));
    }

    public List<UserEntity> findAll() {
        return users;
    }

    public UserEntity save(UserEntity user) {
        int userId = users.size();
        user.setId(++userId);
        users.add(user);
        return user;
    }

    public UserEntity findOne(Integer id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElseThrow(() -> new UserNotFoundException(id));
    }

    public void deleteById(Integer id) {
        users.removeIf(user -> user.getId().equals(id));
    }

}
