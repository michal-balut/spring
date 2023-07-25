package pl.spring.training.todo.rest;

import java.util.List;

import org.mapstruct.Mapper;

import pl.spring.training.todo.domain.TodoItem;

@Mapper(componentModel = "spring")
public interface TodoItemMapper {

	TodoItem toDomain(TodoItemDto todoItemDto);

	TodoItem toDomain(NewTodoDto newTodoDto);

	TodoItem toDomain(String id, UpdatedTodoDto updatedTodoDto);

	TodoItemDto toDto(TodoItem todoItem);

	List<TodoItemDto> toList(List<TodoItem> todoList);
}
