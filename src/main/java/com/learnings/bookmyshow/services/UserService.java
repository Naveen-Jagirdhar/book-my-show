package com.learnings.bookmyshow.services;

import com.learnings.bookmyshow.entities.User;
import com.learnings.bookmyshow.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(String username, String password) {
        return userRepository.save(User.builder().username(username).password(password).build());
    }
}
