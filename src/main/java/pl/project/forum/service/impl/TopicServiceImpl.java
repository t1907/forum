package pl.project.forum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.project.forum.model.Post;
import pl.project.forum.model.Topic;
import pl.project.forum.repository.TopicRepository;
import pl.project.forum.service.TopicService;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicRepository repository;

    @Override
    public Topic add(Topic topic) {
        return repository.save(topic);
    }

    @Override
    public Topic update(Topic topic) {
        Topic savedTopic = repository.findById(topic.getId()).orElseThrow();
        savedTopic.setCategory(topic.getCategory());
        savedTopic.setName(topic.getName());
        return repository.save(savedTopic);
    }

    @Override
    public void delete(Topic topic) {
        Topic savedTopic = repository.findById(topic.getId()).orElseThrow();
        repository.delete(savedTopic);
    }

    @Override
    public List<Topic> getAll() {
        return repository.findAll();
    }

    @Override
    public Topic getById(Long id) {
        Topic savedTopic = repository.findById(id).orElseThrow();
        return savedTopic;
    }
}
