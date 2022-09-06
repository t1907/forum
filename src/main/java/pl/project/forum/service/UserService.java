package pl.project.forum.service;

import pl.project.forum.model.User;

import java.util.List;

public interface UserService {
    public User add(User user);
    public User update(User user);
    public void delete(User user);
    public List<User> getAll();
    public User getById(Long id);
}
