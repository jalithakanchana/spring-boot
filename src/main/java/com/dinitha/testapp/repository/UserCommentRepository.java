package com.dinitha.testapp.repository;

import com.dinitha.testapp.entity.UserComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserCommentRepository extends JpaRepository<UserComment, Long> {

    List<UserComment> findAllByGroceryId(Long groceryId);
}
