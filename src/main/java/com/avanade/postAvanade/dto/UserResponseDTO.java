package com.avanade.postAvanade.dto;

import lombok.Data;
import java.util.List;

@Data
public class UserResponseDTO {
  private Long id;
  private String name;
  private String email;
  private List<PostResponseDTO> posts;
}