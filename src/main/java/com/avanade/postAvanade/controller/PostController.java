package com.avanade.postAvanade.controller;

import com.avanade.postAvanade.dto.PostRequestDTO;
import com.avanade.postAvanade.dto.PostResponseDTO;
import com.avanade.postAvanade.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

  private final PostService postService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(summary = "Create a new post")
  public PostResponseDTO createPost(@RequestBody PostRequestDTO postRequestDTO) {
    return postService.createPost(postRequestDTO);
  }

  @GetMapping("/user/{userId}")
  @Operation(summary = "Get posts by user ID")
  public List<PostResponseDTO> getPostsByUserId(@PathVariable Long userId) {
    return postService.getPostsByUserId(userId);
  }

  @GetMapping("/{id}")
  @Operation(summary = "Get post by ID")
  public PostResponseDTO getPostById(@PathVariable Long id) {
    return postService.getPostById(id);
  }

  @PutMapping("/{id}")
  @Operation(summary = "Update post by ID")
  public PostResponseDTO updatePost(@PathVariable Long id, @RequestBody PostRequestDTO postRequestDTO) {
    return postService.updatePost(id, postRequestDTO);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @Operation(summary = "Delete post by ID")
  public void deletePost(@PathVariable Long id) {
    postService.deletePost(id);
  }
}
