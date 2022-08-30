package pl.project.forum.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.project.forum.model.Category;
import pl.project.forum.repository.CategoryRepository;

import java.util.List;

@RestController
@RequestMapping("category/")
public class CategoryController {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping(value = "/all")
    public ResponseEntity<List<Category>> getAll(){
        List<Category> categories = categoryRepository.findAll();
        return ResponseEntity.ok(categories);
    }

    @PostMapping(value = "/add")
    public ResponseEntity add(@RequestBody Category category){
        Category newCategory = categoryRepository.save(category);
        return ResponseEntity.ok(newCategory);
    }

}
