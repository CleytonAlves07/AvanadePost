package com.avanade.postAvanade.controller;

import com.avanade.postAvanade.dto.UserRequestDTO;
import com.avanade.postAvanade.dto.UserResponseDTO;
import com.avanade.postAvanade.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(summary = "Create a new user")
  public UserResponseDTO createUser(@RequestBody UserRequestDTO userRequestDTO) {
    return userService.createUser(userRequestDTO);
  }

  @GetMapping
  @Operation(summary = "Get all users")
  public List<UserResponseDTO> getAllUsers() {
    return userService.getAllUsers();
  }

  @GetMapping("/{id}")
  @Operation(summary = "Get user by ID")
  public UserResponseDTO getUserById(@PathVariable Long id) {
    return userService.getUserById(id);
  }

  @PutMapping("/{id}")
  @Operation(summary = "Update user by ID")
  public UserResponseDTO updateUser(@PathVariable Long id, @RequestBody UserRequestDTO userRequestDTO) {
    return userService.updateUser(id, userRequestDTO);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @Operation(summary = "Delete user by ID")
  public void deleteUser(@PathVariable Long id) {
    userService.deleteUser(id);
  }
}
