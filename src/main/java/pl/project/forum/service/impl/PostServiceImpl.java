package pl.project.forum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.project.forum.model.Post;
import pl.project.forum.repository.PostRepository;
import pl.project.forum.service.PostService;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository repository;

    @Override
    public Post add(Post post) {
        return repository.save(post);
    }

    @Override
    public Post update(Post post) {
        Post savedPost = repository.findById(post.getId()).orElseThrow();
        savedPost.setUser(post.getUser());
        savedPost.setContext(post.getContext());
        savedPost.setTopic(post.getTopic());
        return repository.save(savedPost);
    }

    @Override
    public void delete(Post post) {
        Post savedPost = repository.findById(post.getId()).orElseThrow();
        repository.delete(savedPost);
    }

    @Override
    public List<Post> getAll() {
        return repository.findAll();
    }

    @Override
    public Post getById(Long id) {
        return repository.findById(id).orElseThrow();
    }
}
