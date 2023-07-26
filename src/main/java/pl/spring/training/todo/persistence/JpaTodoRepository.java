package pl.spring.training.todo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTodoRepository extends JpaRepository<TodoEntity, String> {

}
