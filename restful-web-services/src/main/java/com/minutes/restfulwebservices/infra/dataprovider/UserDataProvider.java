package com.minutes.restfulwebservices.infra.dataprovider;

import com.minutes.restfulwebservices.cross.mapper.UserMapper;
import com.minutes.restfulwebservices.domain.entity.UserEntity;
import com.minutes.restfulwebservices.infra.model.User;
import com.minutes.restfulwebservices.infra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserDataProvider {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper mapper;

    public List<UserEntity> findAll() {
        return mapper.toEntity(repository.findAll());
    }

    public UserEntity save(UserEntity user) {
        User model = mapper.toModel(user);
        User savedModel = repository.save(model);
        return mapper.toEntity(savedModel);
    }

    public UserEntity findById(Integer id) {
        Optional<User> optional = repository.findById(id);
        return optional.map(user -> mapper.toEntity(user)).orElse(null);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

}
