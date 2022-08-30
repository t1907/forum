package pl.project.forum.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.project.forum.model.Category;
import pl.project.forum.model.Post;
import pl.project.forum.repository.PostRepository;

import java.util.List;

@RestController
@RequestMapping("post/")
public class PostController {

    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    PostRepository postRepository;

    @GetMapping(value = "/all")
    public ResponseEntity<List<Post>> getAll(){
        List<Post> posts = postRepository.findAll();
        return ResponseEntity.ok(posts);
    }

    @PostMapping(value = "/add")
    public ResponseEntity add(@RequestBody Post post){
        Post newPost = postRepository.save(post);
        return ResponseEntity.ok(newPost);
    }
}
