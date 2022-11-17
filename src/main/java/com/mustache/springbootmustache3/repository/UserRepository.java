package com.mustache.springbootmustache3.repository;

import com.mustache.springbootmustache3.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
