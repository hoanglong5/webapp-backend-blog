package com.hoanglong.springbootblogwebapp.post.controller;

import com.hoanglong.springbootblogwebapp.init.controller.RestResponse;
import com.hoanglong.springbootblogwebapp.init.enums.MessageResponse;
import com.hoanglong.springbootblogwebapp.post.dto.PostDto;
import com.hoanglong.springbootblogwebapp.post.entity.Post;
import com.hoanglong.springbootblogwebapp.post.service.PostService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/${application.version}/post")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PostController {
    PostService postService;
    @GetMapping
    public ResponseEntity<RestResponse<List<PostDto>>> GetAllPost(){
        RestResponse<List<PostDto>> response = RestResponse.of(postService.FindAllPost());
        response.setMessage(MessageResponse.SUCCESSFULLY_FINDALL.getMessage());
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{uuid}")
    public ResponseEntity<RestResponse<PostDto>> FindPostById(@PathVariable UUID uuid){
        RestResponse<PostDto> response = RestResponse.of(postService.FindPostById(uuid));
        response.setMessage(MessageResponse.SUCCESSFULLY_FINDBYID.getMessage());
        return ResponseEntity.ok(response);
    }
    @PostMapping
    public ResponseEntity<RestResponse<UUID>> CreatePost(@RequestBody Post post){
        RestResponse<UUID> response = RestResponse.of(postService.CreateNewPost(post));
        response.setMessage(MessageResponse.SUCCESSFULLY_UPDATED.getMessage());
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{uuid}")
    public ResponseEntity<RestResponse<UUID>> DeletePost(@PathVariable UUID uuid){
        RestResponse<UUID> response = RestResponse.of(postService.DeletePost(uuid));
        response.setMessage(MessageResponse.SUCCESSFULLY_DELETE.getMessage());
        return ResponseEntity.ok(response);
    }
    @PutMapping("/{uuid}")
    public ResponseEntity<RestResponse<UUID>> UpdatePost(@RequestBody Post post,@PathVariable UUID uuid){
        RestResponse<UUID> response = RestResponse.of(postService.UpdatePost(uuid,post));
        response.setMessage(MessageResponse.SUCCESSFULLY_UPDATED.getMessage());
        return ResponseEntity.ok(response);
    }
}
