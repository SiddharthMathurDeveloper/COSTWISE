package com.costwiseai.costwise.repository;

import com.costwiseai.costwise.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    @Override
    Optional<User> findById(Integer integer);
}
