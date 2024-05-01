package com.minutes.restfulwebservices.domain.usecase;

import com.minutes.restfulwebservices.domain.entity.PostEntity;

import java.util.List;

public interface IPostUseCase {

    List<PostEntity> findPosts(Integer userId);

    PostEntity createPost(PostEntity entity);

}
