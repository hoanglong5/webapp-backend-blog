package com.hoanglong.springbootblogwebapp.post.service;

import com.hoanglong.springbootblogwebapp.init.service.BaseEntityService;
import com.hoanglong.springbootblogwebapp.post.entity.Post;
import com.hoanglong.springbootblogwebapp.post.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class PostService extends BaseEntityService<Post, PostRepository> {
    public PostService(PostRepository dao) {
        super(dao);
    }
    public List<Post> FindAll(){
        return getDao().findAll();
    }
    public Post FindPostbyID(UUID id ){
        Post post = FindById(id);
        return post;
    }
    public UUID DeletePost(UUID id){
        getDao().deleteById(id);
        return id;
    }
    public void SavePost(Post post){
        getDao().save(post);
    }
    public UUID UpdatePost(Post post,UUID id){
        Post postToUpdate = FindById(id);
        postToUpdate.setContent(post.getContent());
        postToUpdate.setTitle(postToUpdate.getTitle());
        getDao().save(postToUpdate);
        return id;
    }
}
