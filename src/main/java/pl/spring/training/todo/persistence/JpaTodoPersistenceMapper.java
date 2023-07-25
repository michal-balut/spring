package pl.spring.training.todo.persistence;

import org.mapstruct.Mapper;
import pl.spring.training.todo.domain.TodoItem;

@Mapper(componentModel = "spring")
public interface JpaTodoPersistenceMapper {
    TodoEntity toEntity(TodoItem todoItem);

    TodoItem toDomain(TodoEntity paymentEntity);

}
