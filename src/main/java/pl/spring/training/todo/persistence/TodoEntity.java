package pl.spring.training.todo.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity(name = "Todo")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class TodoEntity {

    @Id
    private String id;
    private Boolean isDone;
    private String name;
}
