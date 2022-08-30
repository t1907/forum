package pl.project.forum.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.project.forum.model.User;
import pl.project.forum.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("user/")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }
    @PostMapping("/add")
    public  ResponseEntity addUser(@RequestBody User user){
        User newUser = userRepository.save(user);
        return ResponseEntity.ok(newUser);
    }
}
