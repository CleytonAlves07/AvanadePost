package com.avanade.postAvanade.service.impl;

import com.avanade.postAvanade.domain.model.Post;
import com.avanade.postAvanade.domain.model.User;
import com.avanade.postAvanade.domain.repository.PostRepository;
import com.avanade.postAvanade.domain.repository.UserRepository;
import com.avanade.postAvanade.dto.PostRequestDTO;
import com.avanade.postAvanade.dto.PostResponseDTO;
import com.avanade.postAvanade.excepition.ResourceNotFoundException;
import com.avanade.postAvanade.service.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

  private final PostRepository postRepository;
  private final UserRepository userRepository;
  private final ModelMapper modelMapper;

  @Override
  public PostResponseDTO createPost(PostRequestDTO postRequestDTO) {
    User user = userRepository.findById(postRequestDTO.getUserId())
        .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + postRequestDTO.getUserId()));

    Post post = modelMapper.map(postRequestDTO, Post.class);
    post.setUser(user);
    Post savedPost = postRepository.save(post);
    return modelMapper.map(savedPost, PostResponseDTO.class);
  }

  @Override
  public List<PostResponseDTO> getPostsByUserId(Long userId) {
    List<Post> posts = postRepository.findByUserId(userId);
    return posts.stream()
        .map(post -> modelMapper.map(post, PostResponseDTO.class))
        .collect(Collectors.toList());
  }

  @Override
  public PostResponseDTO getPostById(Long id) {
    Post post = postRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + id));
    return modelMapper.map(post, PostResponseDTO.class);
  }

  @Override
  public PostResponseDTO updatePost(Long id, PostRequestDTO postRequestDTO) {
    Post existingPost = postRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + id));
    modelMapper.map(postRequestDTO, existingPost);
    Post updatedPost = postRepository.save(existingPost);
    return modelMapper.map(updatedPost, PostResponseDTO.class);
  }

  @Override
  public void deletePost(Long id) {
    postRepository.deleteById(id);
  }
}
