package com.example.testproject.controller;

import com.example.testproject.entity.Post;
import com.example.testproject.payload.PostDTO;
import com.example.testproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/post")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostDTO> createPost(PostDTO postDTO){
        return  new ResponseEntity<>(postService.createPost(postDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public  ResponseEntity<List<Post>> getAll(){
        return new ResponseEntity<>(postService.getAllPost(),HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public  ResponseEntity<PostDTO> getById(
            @PathVariable(name = "id") Long id
    ){
        return  new ResponseEntity<>(postService.getPostById(id),HttpStatus.OK);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<PostDTO> updatePost(
            @PathVariable(name = "id") Long id,
            @Valid @RequestBody PostDTO postDTO
    ){
        PostDTO response = postService.updatePost(postDTO,id);
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }

}
