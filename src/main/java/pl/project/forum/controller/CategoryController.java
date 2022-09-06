package pl.project.forum.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.project.forum.model.Category;
import pl.project.forum.repository.CategoryRepository;
import pl.project.forum.service.CategoryService;

import java.util.List;


@RestController
@RequestMapping("category/")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping(value = "/get/all")
    public ResponseEntity<List<Category>> getAll(){
        List<Category> categories = service.getAll();
        return ResponseEntity.ok(categories);
    }
    @GetMapping(value = "/get/{id}")
    public ResponseEntity<Category> getById(@PathVariable Long id){
        Category categoryFromDB = service.getById(id);
        return ResponseEntity.ok(categoryFromDB);
    }

    @PostMapping(value = "/add")
    public ResponseEntity add(@RequestBody Category category){
        Category newCategory = service.add(category);
        return ResponseEntity.ok(newCategory);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Category> updatePost(@RequestBody Category category, @PathVariable Long id){
        Category categoryFromDB = service.getById(id);
        categoryFromDB.setCategoryName(category.getCategoryName());
        service.add(categoryFromDB);
        return ResponseEntity.ok(categoryFromDB);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable Long id){
        Category categoryFromDB = service.getById(id);
        service.delete(categoryFromDB);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
