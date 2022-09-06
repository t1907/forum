package pl.project.forum.service;

import pl.project.forum.model.Topic;

import java.util.List;

public interface TopicService {
    public Topic add(Topic topic);
    public Topic update(Topic topic);
    public void delete(Topic topic);
    public List<Topic> getAll();
    public Topic getById(Long id);
}
