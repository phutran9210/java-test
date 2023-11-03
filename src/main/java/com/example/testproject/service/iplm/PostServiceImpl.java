package com.example.testproject.service.iplm;

import com.example.testproject.entity.Post;
import com.example.testproject.entity.mapper.PostMapper;
import com.example.testproject.exception.ResourceNotFoundException;
import com.example.testproject.payload.PostDTO;
import com.example.testproject.repository.PostRepository;
import com.example.testproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;


    @Autowired
    public PostServiceImpl(PostRepository postRepository,PostMapper postMapper) {
        this.postMapper = postMapper;
        this.postRepository = postRepository;
    }

    @Override
    public PostDTO createPost(PostDTO postDTO) {

        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setDescription(postDTO.getDescription());
        post.setContent(postDTO.getContent());
        Post newpost = postRepository.save(post);

        PostDTO postResponse = new PostDTO();
        postResponse.setId(newpost.getId());
        postResponse.setContent(newpost.getContent());
        postResponse.setTitle(newpost.getTitle());
        postResponse.setDescription(newpost.getDescription());

        return postResponse;
    }

    @Override
    public List<Post> getAllPost() {
        return  postRepository.findAll();

    }

    @Override
    public PostDTO getPostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post","id",id));
        return mapToDTO(post);
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO, Long id) {
        Post post = postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post","id",id));

        postMapper.updatePostToDTO(postDTO,post);
        Post updatedpost= postRepository.save(post);

        return mapToDTO(updatedpost);
    }

    private PostDTO mapToDTO(Post post){
        PostDTO postDTO = new PostDTO();
        postDTO.setId(post.getId());
        postDTO.setContent(post.getContent());
        postDTO.setTitle(post.getTitle());
        postDTO.setDescription(post.getDescription());
        return  postDTO;
    }
}
