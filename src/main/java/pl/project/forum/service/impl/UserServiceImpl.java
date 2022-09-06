package pl.project.forum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.project.forum.model.User;
import pl.project.forum.repository.UserRepository;
import pl.project.forum.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User add(User user) {
        return repository.save(user);
    }

    @Override
    public User update(User user) {
        User savedUser = repository
                .findById(user.getId())
                .orElseThrow();
        savedUser.setUsername(user.getUsername());
        savedUser.setPassword(user.getPassword());
        return repository.save(savedUser);
    }

    @Override
    public void delete(User user) {
        User savedUser = repository
                .findById(user.getId())
                .orElseThrow();
        repository.delete(savedUser);
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public User getById(Long id) {
        User savedUser = repository
                .findById(id)
                .orElseThrow();
        return savedUser;
    }
}
