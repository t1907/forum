package pl.project.forum.service;

import pl.project.forum.model.Category;

import java.util.List;

public interface CategoryService {
    public Category add(Category category);
    public Category update(Category category);
    public void delete(Category category);
    public List<Category> getAll();
    public Category getById(Long id);
}
