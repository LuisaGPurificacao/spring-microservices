package com.minutes.restfulwebservices.app.service.impl;

import com.minutes.restfulwebservices.app.dto.request.PostSaveRequest;
import com.minutes.restfulwebservices.app.dto.response.PostResponse;
import com.minutes.restfulwebservices.app.service.IPostService;
import com.minutes.restfulwebservices.cross.mapper.PostMapper;
import com.minutes.restfulwebservices.domain.entity.PostEntity;
import com.minutes.restfulwebservices.domain.entity.UserEntity;
import com.minutes.restfulwebservices.domain.usecase.IPostUseCase;
import com.minutes.restfulwebservices.domain.usecase.IUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements IPostService {

    @Autowired
    IPostUseCase useCase;

    @Autowired
    IUserUseCase userUseCase;

    @Autowired
    PostMapper mapper;

    public List<PostResponse> findPosts(Integer userId) {
        userUseCase.findOne(userId);
        return mapper.toResponse(useCase.findPosts(userId));
    }

    public PostResponse createPost(Integer userId, PostSaveRequest request) {
        UserEntity user = userUseCase.findOne(userId);
        PostEntity post = mapper.toEntity(request);
        post.setUser(user);
        return mapper.toResponse(useCase.createPost(post));
    }

}
