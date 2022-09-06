package pl.project.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.project.forum.model.Post;
import pl.project.forum.repository.PostRepository;
import pl.project.forum.service.PostService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("post/")
public class PostController {

    @Autowired
    PostService service;

    @GetMapping(value = "/get/all")
    public ResponseEntity<List<Post>> getAll(){
        List<Post> posts = service.getAll();
        return ResponseEntity.ok(posts);
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id){
        Post postFromDB = service.getById(id);
        return ResponseEntity.ok(postFromDB);
    }

    @PostMapping(value = "/add")
    public ResponseEntity add(@RequestBody Post post){
        Post newPost = service.add(post);
        return ResponseEntity.ok(newPost);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Post> updatePost(@RequestBody Post post, @PathVariable Long id){
        Post updatePost = service.getById(id);
        updatePost.setContext(post.getContext());
        updatePost.setTopic(post.getTopic());
        updatePost.setUser(post.getUser());
        service.add(updatePost);
        return ResponseEntity.ok(updatePost);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Post> deletePost(@PathVariable Long id){
        Post deletePost = service.getById(id);
        service.delete(deletePost);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
