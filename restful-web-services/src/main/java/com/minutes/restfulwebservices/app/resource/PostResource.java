package com.minutes.restfulwebservices.app.resource;

import com.minutes.restfulwebservices.app.dto.request.PostSaveRequest;
import com.minutes.restfulwebservices.app.dto.response.PostResponse;
import com.minutes.restfulwebservices.app.service.IPostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostResource {

    @Autowired
    private IPostService postService;

    @GetMapping(path = "/users/{userId}/posts")
    public List<PostResponse> retrievePosts(@PathVariable Integer userId) {
        return postService.findPosts(userId);
    }

    @PostMapping(path = "/users/{userId}/posts")
    public PostResponse createPost(@PathVariable Integer userId, @RequestBody @Valid PostSaveRequest request) {
        return postService.createPost(userId, request);
    }

}
