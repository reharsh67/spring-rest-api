package com.reharsh.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reharsh.blog.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
