package com.avanade.postAvanade.dto;

import lombok.Data;

@Data
public class PostResponseDTO {
  private Long id;
  private String title;
  private String content;
  private Long userId;
}