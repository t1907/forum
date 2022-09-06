package pl.project.forum.service;

import pl.project.forum.model.Post;

import java.util.List;

public interface PostService {
    public Post add(Post post);
    public Post update(Post post);
    public void delete(Post post);
    public List<Post> getAll();
    public Post getById(Long id);
}
