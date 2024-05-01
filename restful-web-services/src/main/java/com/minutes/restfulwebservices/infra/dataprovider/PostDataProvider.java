package com.minutes.restfulwebservices.infra.dataprovider;

import com.minutes.restfulwebservices.cross.mapper.PostMapper;
import com.minutes.restfulwebservices.domain.entity.PostEntity;
import com.minutes.restfulwebservices.infra.model.Post;
import com.minutes.restfulwebservices.infra.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostDataProvider {

    @Autowired
    private PostRepository repository;

    @Autowired
    private PostMapper mapper;

    public List<PostEntity> findPosts(Integer userId) {
        return mapper.toEntity(repository.findPostByUserId(userId));
    }

    public PostEntity savePost(PostEntity entity) {
        Post savedPost = repository.save(mapper.toModel(entity));
        return mapper.toEntity(savedPost);
    }

}
