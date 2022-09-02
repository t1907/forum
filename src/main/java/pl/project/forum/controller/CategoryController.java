package pl.project.forum.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping(value = "/get/all")
    public ResponseEntity<List<Category>> getAll(){
        List<Category> categories = categoryRepository.findAll();
        return ResponseEntity.ok(categories);
    }
    @GetMapping(value = "/get/{id}")
    public ResponseEntity<Category> getById(@PathVariable Long id){
        Category categoryFromDB = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kategoria nie istnieje"));
        return ResponseEntity.ok(categoryFromDB);
    }

    @PostMapping(value = "/add")
    public ResponseEntity add(@RequestBody Category category){
        Category newCategory = categoryRepository.save(category);
        return ResponseEntity.ok(newCategory);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Category> updatePost(@RequestBody Category category, @PathVariable Long id){
        Category categoryFromDB = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kategoria nie istnieje"));

        categoryFromDB.setCategoryName(category.getCategoryName());

        categoryRepository.save(categoryFromDB);

        return ResponseEntity.ok(categoryFromDB);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable Long id){
        Category categoryFromDB = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kategoria nie istnieje"));
        categoryRepository.delete(categoryFromDB);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
