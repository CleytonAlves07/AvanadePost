package com.avanade.postAvanade.domain.repository;

import com.avanade.postAvanade.domain.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
  List<Post> findByUserId(Long userId);
}
