package com.hoanglong.springbootblogwebapp.post.mapper;

import com.hoanglong.springbootblogwebapp.post.dto.PostDto;
import com.hoanglong.springbootblogwebapp.post.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper()
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);
    PostDto PostToPostDto(Post post);
    List<PostDto> PostsToPostDtos(List<Post> posts);
}
