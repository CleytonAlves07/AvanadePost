package com.avanade.postAvanade.domain.repository;

import com.avanade.postAvanade.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
