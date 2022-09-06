package pl.project.forum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.project.forum.model.Category;
import pl.project.forum.repository.CategoryRepository;
import pl.project.forum.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Override
    public Category add(Category category) {
        return repository.save(category);
    }

    @Override
    public Category update(Category category) {
        Category savedCategory = repository.findById(category.getId()).orElseThrow();
        savedCategory.setCategoryName(category.getCategoryName());
        return repository.save(savedCategory);
    }

    @Override
    public void delete(Category category) {
        Category savedCategory = repository.findById(category.getId()).orElseThrow();
        repository.delete(savedCategory);
    }

    @Override
    public List<Category> getAll() {
        return repository.findAll();
    }

    @Override
    public Category getById(Long id) {
        return repository.findById(id).orElseThrow();
    }
}
