package pl.project.forum.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.project.forum.model.User;
import pl.project.forum.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user/")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/get/all")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id){
        Optional<User> user = userRepository.findById(id);
        return ResponseEntity.ok(user);
    }
    @PostMapping("/add")
    public  ResponseEntity addUser(@RequestBody User user){
        User newUser = userRepository.save(user);
        return ResponseEntity.ok(newUser);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user){
       User updateUser = userRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("Użytkownik nie istnieje"));

       updateUser.setUsername(user.getUsername());
       updateUser.setPassword(user.getPassword());

       userRepository.save(updateUser);

       return ResponseEntity.ok(updateUser);
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id){
        User deleteUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Użytkownik nie istnieje"));
        userRepository.delete(deleteUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
