package com.hoanglong.springbootblogwebapp.post.service;

import com.hoanglong.springbootblogwebapp.post.dto.PostDto;
import com.hoanglong.springbootblogwebapp.post.entity.Post;
import com.hoanglong.springbootblogwebapp.post.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostEntityService postEntityService;
    public List<PostDto> FindAllPost(){
        List<Post> posts = postEntityService.FindAll();
        List<PostDto> postDtos = PostMapper.INSTANCE.PostsToPostDtos(posts);
        return postDtos;
    }
    public PostDto FindPostById(UUID uuid){
        Post post = postEntityService.FindById(uuid);
        PostDto postDto = PostMapper.INSTANCE.PostToPostDto(post);
        return postDto;
    }
    public UUID DeletePost(UUID uuid){
        postEntityService.DeletePost(uuid);
        return uuid;
    }
    public UUID UpdatePost(UUID uuid,Post post){
        postEntityService.UpdatePost(post,uuid);
        return uuid;
    }
    public UUID CreateNewPost(Post post){
        Post PostInfo = new Post();
        PostInfo.setTitle(post.getTitle());
        PostInfo.setContent(post.getContent());
        PostInfo.setTags(post.getTags());
        PostInfo.setCreatedDate(LocalDate.now());
        PostInfo.setCreatedBy(null);
        PostInfo.setModifiedDate(LocalDate.now());
        PostInfo.setModifiedBy(null);
        postEntityService.Save(PostInfo);
        return PostInfo.getId();
    }
}
