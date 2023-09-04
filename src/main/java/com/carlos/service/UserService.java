package com.carlos.service;

import com.carlos.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    public List<User> getAllUser();
    public void save(User user);
    Optional<User> findByUsername(String username);

    public void deleteUser(int userId);
}
