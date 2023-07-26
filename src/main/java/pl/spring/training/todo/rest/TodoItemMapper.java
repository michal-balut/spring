package pl.spring.training.todo.rest;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import pl.spring.training.todo.domain.TodoItem;

@Mapper(componentModel = "spring")
public interface TodoItemMapper {

	TodoItem todoItemDtoToTodoItem(TodoItemDto todoItemDto);

	TodoItem todoItemDtoToTodoItem(NewTodoDto newTodoDto);

	TodoItem todoItemDtoToTodoItem(UpdatedTodoDto updatedTodoDto);

	TodoItemDto todoItemToTodoItemDto(TodoItem todoItem);

	@IterableMapping(elementTargetType = TodoItemDto.class)
	List<TodoItemDto> todoItemToTodoItemDto(List<TodoItem> todoList);
}
