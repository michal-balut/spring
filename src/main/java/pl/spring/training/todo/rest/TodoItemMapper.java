package pl.spring.training.todo.rest;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import pl.spring.training.todo.domain.TodoItem;

@Mapper(componentModel = "spring")
public interface TodoItemMapper {

	TodoItem toDomain(TodoItemDto todoItemDto);

	TodoItem toDomain(NewTodoDto newTodoDto);

	TodoItemDto toDto(TodoItem todoItem);
}
