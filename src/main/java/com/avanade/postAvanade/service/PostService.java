package com.avanade.postAvanade.service;

import com.avanade.postAvanade.dto.PostRequestDTO;
import com.avanade.postAvanade.dto.PostResponseDTO;

import java.util.List;

public interface PostService {
  PostResponseDTO createPost(PostRequestDTO postRequestDTO);
  List<PostResponseDTO> getPostsByUserId(Long userId);
  PostResponseDTO getPostById(Long id);
  PostResponseDTO updatePost(Long id, PostRequestDTO postRequestDTO);
  void deletePost(Long id);
}
