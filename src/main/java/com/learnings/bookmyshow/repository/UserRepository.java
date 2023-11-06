package com.learnings.bookmyshow.repository;

import com.learnings.bookmyshow.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
