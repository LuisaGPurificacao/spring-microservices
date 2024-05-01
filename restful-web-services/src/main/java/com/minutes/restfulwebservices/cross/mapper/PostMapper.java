package com.minutes.restfulwebservices.cross.mapper;

import com.minutes.restfulwebservices.app.dto.request.PostSaveRequest;
import com.minutes.restfulwebservices.app.dto.response.PostResponse;
import com.minutes.restfulwebservices.domain.entity.PostEntity;
import com.minutes.restfulwebservices.infra.model.Post;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PostMapper {

    List<PostResponse> toResponse(List<PostEntity> entity);

    PostResponse toResponse(PostEntity entity);

    PostEntity toEntity(PostSaveRequest request);

    Post toModel(PostEntity entity);

    PostEntity toEntity(Post model);

    List<PostEntity> toEntity(List<Post> model);

}
