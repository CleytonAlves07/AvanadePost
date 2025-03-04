package com.avanade.postAvanade.service.impl;

import com.avanade.postAvanade.domain.model.User;
import com.avanade.postAvanade.domain.repository.UserRepository;
import com.avanade.postAvanade.dto.UserRequestDTO;
import com.avanade.postAvanade.dto.UserResponseDTO;
import com.avanade.postAvanade.excepition.ResourceNotFoundException;
import com.avanade.postAvanade.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final ModelMapper modelMapper;

  @Override
  public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
    User user = modelMapper.map(userRequestDTO, User.class);
    User savedUser = userRepository.save(user);
    return modelMapper.map(savedUser, UserResponseDTO.class);
  }

  @Override
  public List<UserResponseDTO> getAllUsers() {
    return userRepository.findAll().stream()
        .map(user -> modelMapper.map(user, UserResponseDTO.class))
        .collect(Collectors.toList());
  }

  @Override
  public UserResponseDTO getUserById(Long id) {
    User user = userRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    return modelMapper.map(user, UserResponseDTO.class);
  }

  @Override
  public UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO) {
    User existingUser = userRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    modelMapper.map(userRequestDTO, existingUser);
    User updatedUser = userRepository.save(existingUser);
    return modelMapper.map(updatedUser, UserResponseDTO.class);
  }

  @Override
  public void deleteUser(Long id) {
    userRepository.deleteById(id);
  }
}
