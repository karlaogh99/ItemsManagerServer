package com.carlos.service;

import com.carlos.model.User;
import com.carlos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImple implements UserService {
    @Autowired
    UserRepository repository;
    @Override
    public List<User> getAllUser() {
        return repository.findAll();
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public void deleteUser(int userId) {
        User usuarioABorrar = repository.findById(userId).get();
        repository.delete(usuarioABorrar);
    }
}
