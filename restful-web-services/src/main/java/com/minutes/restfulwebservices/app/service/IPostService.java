package com.minutes.restfulwebservices.app.service;

import com.minutes.restfulwebservices.app.dto.request.PostSaveRequest;
import com.minutes.restfulwebservices.app.dto.response.PostResponse;

import java.util.List;

public interface IPostService {

    List<PostResponse> findPosts(Integer userId);

    PostResponse createPost(Integer userId, PostSaveRequest request);

}
