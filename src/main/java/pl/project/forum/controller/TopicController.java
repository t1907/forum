package pl.project.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.project.forum.model.Topic;
import pl.project.forum.repository.TopicRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("topic/")
public class TopicController {

    @Autowired
    TopicRepository topicRepository;

    @GetMapping(value = "/get/all")
    public ResponseEntity<List<Topic>> getAll(){
        List<Topic> topics = topicRepository.findAll();
        return ResponseEntity.ok(topics);
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<Optional<Topic>> getTopicById(@PathVariable Long id){
        Optional<Topic>topicFromDB = topicRepository.findById(id);
        return ResponseEntity.ok(topicFromDB);
    }

    @PostMapping(value = "/add")
    public ResponseEntity add(@RequestBody Topic topic){
        Topic newTopic = topicRepository.save(topic);
        return ResponseEntity.ok(newTopic);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Topic> updateTopic(@RequestBody Topic topic, @PathVariable Long id){
        Topic updateTopic = topicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Temat nie istnieje"));

        updateTopic.setName(topic.getName());
        updateTopic.setCategory(topic.getCategory());
        topicRepository.save(updateTopic);
        return ResponseEntity.ok(topic);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Topic> deleteTopic(@PathVariable Long id){
        Topic deleteTopic = topicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Temat nie istnieje"));

        topicRepository.delete(deleteTopic);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
