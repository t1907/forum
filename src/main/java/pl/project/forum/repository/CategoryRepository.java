package pl.project.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.project.forum.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
