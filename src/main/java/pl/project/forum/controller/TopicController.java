package pl.project.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.project.forum.model.Topic;
import pl.project.forum.repository.TopicRepository;
import pl.project.forum.service.TopicService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("topic/")
public class TopicController {

    @Autowired
    TopicService service;

    @GetMapping(value = "/get/all")
    public ResponseEntity<List<Topic>> getAll(){
        List<Topic> topics = service.getAll();
        return ResponseEntity.ok(topics);
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<Topic> getTopicById(@PathVariable Long id){
        Topic topicFromDB = service.getById(id);
        return ResponseEntity.ok(topicFromDB);
    }

    @PostMapping(value = "/add")
    public ResponseEntity add(@RequestBody Topic topic){
        Topic newTopic = service.add(topic);
        return ResponseEntity.ok(newTopic);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Topic> updateTopic(@RequestBody Topic topic, @PathVariable Long id){
        Topic updateTopic = service.getById(id);
        updateTopic.setName(topic.getName());
        updateTopic.setCategory(topic.getCategory());
        service.add(updateTopic);
        return ResponseEntity.ok(topic);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Topic> deleteTopic(@PathVariable Long id){
        Topic deleteTopic = service.getById(id);
        service.delete(deleteTopic);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
