package pl.spring.training.todo.persistence;

import org.mapstruct.Mapper;
import pl.spring.training.todo.domain.TodoItem;

@Mapper(componentModel = "spring")
public interface JpaTodoPersistenceMapper {
    TodoEntity todoItemToTodoEntity(TodoItem todoItem);

    TodoItem todoEntityToTodoItem(TodoEntity todoEntity);

}
