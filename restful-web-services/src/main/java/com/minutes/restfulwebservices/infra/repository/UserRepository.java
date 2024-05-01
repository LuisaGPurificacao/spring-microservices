package com.minutes.restfulwebservices.infra.repository;

import com.minutes.restfulwebservices.infra.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
