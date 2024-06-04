package com.hoanglong.springbootblogwebapp.post.service;

import com.hoanglong.springbootblogwebapp.init.service.BaseEntityService;
import com.hoanglong.springbootblogwebapp.post.entity.Post;
import com.hoanglong.springbootblogwebapp.post.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class PostEntityService extends BaseEntityService<Post, PostRepository> {
    public PostEntityService(PostRepository dao) {
        super(dao);
    }
    public UUID DeletePost(UUID id){
        getDao().deleteById(id);
        return id;
    }
    public UUID UpdatePost(Post post,UUID id){
        Post postToUpdate = FindById(id);
        postToUpdate.setContent(post.getContent());
        postToUpdate.setTitle(postToUpdate.getTitle());
        getDao().save(postToUpdate);
        return id;
    }
}
