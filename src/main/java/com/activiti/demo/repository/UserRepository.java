package com.activiti.demo.repository;

import com.activiti.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    User findUserByUsername(String username);
}
