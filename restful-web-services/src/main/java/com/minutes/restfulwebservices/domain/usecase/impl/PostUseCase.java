package com.minutes.restfulwebservices.domain.usecase.impl;

import com.minutes.restfulwebservices.domain.entity.PostEntity;
import com.minutes.restfulwebservices.domain.usecase.IPostUseCase;
import com.minutes.restfulwebservices.infra.dataprovider.PostDataProvider;
import com.minutes.restfulwebservices.infra.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostUseCase implements IPostUseCase {

    @Autowired
    PostDataProvider dataProvider;

    public List<PostEntity> findPosts(Integer userId) {
        return dataProvider.findPosts(userId);
    }

    public PostEntity createPost(PostEntity entity) {
        return dataProvider.savePost(entity);
    }

}
