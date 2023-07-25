package pl.spring.training.todo.rest;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import pl.spring.training.todo.domain.TodoItem;

@Mapper(componentModel = "spring")
public interface TodoItemMapper {

	TodoItem toDomain(TodoItemDto todoItemDto);

	TodoItem toDomain(NewTodoDto newTodoDto);

	TodoItem toDomain(UpdatedTodoDto updatedTodoDto);

	TodoItemDto toDto(TodoItem todoItem);

	@IterableMapping(elementTargetType = TodoItemDto.class)
	List<TodoItemDto> toDto(List<TodoItem> todoList);
}
