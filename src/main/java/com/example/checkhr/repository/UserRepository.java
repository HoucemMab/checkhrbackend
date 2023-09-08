package com.example.checkhr.repository;

import com.example.checkhr.model.Role;
import com.example.checkhr.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
     List<User> findUsersByRole(Role role);
     Optional<User> findUsersByUsername(String username);
}
