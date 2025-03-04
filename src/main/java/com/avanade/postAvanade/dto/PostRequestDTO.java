package com.avanade.postAvanade.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class PostRequestDTO {
  @NotBlank(message = "Title is mandatory")
  private String title;

  private String content;

  @NotNull(message = "User ID is mandatory")
  private Long userId;
}
