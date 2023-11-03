package com.example.testproject.service;

import com.example.testproject.entity.Post;
import com.example.testproject.payload.PostDTO;

import java.util.List;

public interface PostService {
    PostDTO createPost(PostDTO postDTO);
    List<Post> getAllPost();

    PostDTO getPostById(Long id);

    PostDTO updatePost(PostDTO postDTO, Long id);
}
