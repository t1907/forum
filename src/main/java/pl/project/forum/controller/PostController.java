package pl.project.forum.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.project.forum.model.Category;
import pl.project.forum.model.Post;
import pl.project.forum.repository.PostRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("post/")
public class PostController {

    @Autowired
    PostRepository postRepository;

    @GetMapping(value = "/get/all")
    public ResponseEntity<List<Post>> getAll(){
        List<Post> posts = postRepository.findAll();
        return ResponseEntity.ok(posts);
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<Optional<Post>> getPostById(@PathVariable Long id){
        Optional<Post> postFromDB = postRepository.findById(id);
        return ResponseEntity.ok(postFromDB);
    }

    @PostMapping(value = "/add")
    public ResponseEntity add(@RequestBody Post post){
        Post newPost = postRepository.save(post);
        return ResponseEntity.ok(newPost);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Post> updatePost(@RequestBody Post post, @PathVariable Long id){
        Post updatePost = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post nie istnieje"));

        updatePost.setContext(updatePost.getContext());
        updatePost.setTopic(updatePost.getTopic());
        updatePost.setUser(updatePost.getUser());

        postRepository.save(updatePost);

        return ResponseEntity.ok(updatePost);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Post> deletePost(@PathVariable Long id){
        Post deletePost = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post nie istnieje"));

        postRepository.delete(deletePost);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
