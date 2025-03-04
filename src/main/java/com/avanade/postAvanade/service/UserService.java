package com.avanade.postAvanade.service;

import com.avanade.postAvanade.dto.UserRequestDTO;
import com.avanade.postAvanade.dto.UserResponseDTO;

import java.util.List;

public interface UserService {
  UserResponseDTO createUser(UserRequestDTO userRequestDTO);
  List<UserResponseDTO> getAllUsers();
  UserResponseDTO getUserById(Long id);
  UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO);
  void deleteUser(Long id);
}
