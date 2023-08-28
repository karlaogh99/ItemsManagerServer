package com.carlos.service;

import com.carlos.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    public List<User> getAllUser();
    public void save(User user);
}
