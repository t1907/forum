package pl.project.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.project.forum.model.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
}
