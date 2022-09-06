package pl.project.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.project.forum.model.User;
import pl.project.forum.service.UserService;

import java.util.List;

@RestController
@RequestMapping("user/")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/get/all")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = service.getAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity <User> getUserById(@PathVariable Long id){
        User user = service.getById(id);
        return ResponseEntity.ok(user);
    }
    @PostMapping("/add")
    public  ResponseEntity addUser(@RequestBody User user){
        User newUser = service.add(user);
        return ResponseEntity.ok(newUser);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user){
       User updateUser = service.getById(id);
       updateUser.setUsername(user.getUsername());
       updateUser.setPassword(user.getPassword());

       service.add(updateUser);

       return ResponseEntity.ok(updateUser);
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id){
        User deleteUser = service.getById(id);
        service.delete(deleteUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
