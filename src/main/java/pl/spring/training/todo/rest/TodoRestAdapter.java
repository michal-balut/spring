package pl.spring.training.todo.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.spring.training.todo.ports.TodoService;

import java.util.List;

@RequestMapping("todos")
@RestController
@RequiredArgsConstructor
public class TodoRestAdapter {

	private final TodoService todoProcessor;

	private final TodoItemMapper todoItemMapper;

	@GetMapping("{id}")
	public ResponseEntity<TodoItemDto> getById(@PathVariable String id) {
		var todoItem = todoProcessor.getById(id);
		var todoItemDto = todoItemMapper.todoItemToTodoItemDto(todoItem);
		return ResponseEntity.ok(todoItemDto);
	}

	@PutMapping("{id}")
	public ResponseEntity<TodoItemDto> updateById(@PathVariable String id, @RequestBody UpdatedTodoDto updatedTodoDto) {
		var todoItem = todoItemMapper.todoItemDtoToTodoItem(updatedTodoDto);
		var updatedTodoItem = todoProcessor.update(id, todoItem);
		var updatedTodoItemDto = todoItemMapper.todoItemToTodoItemDto(updatedTodoItem);
		return ResponseEntity.ok(updatedTodoItemDto);
	}

	@PostMapping
	public ResponseEntity<TodoItemDto> create(@RequestBody NewTodoDto newTodoDto) {
		var todoItem = todoItemMapper.todoItemDtoToTodoItem(newTodoDto);
		var createdTodoItem = todoProcessor.create(todoItem);
		var todoItemDto = todoItemMapper.todoItemToTodoItemDto(createdTodoItem);
		return ResponseEntity.status(HttpStatus.CREATED).body(todoItemDto);
	}

	@GetMapping
	public ResponseEntity<List<TodoItemDto>> list() {
		var todoList = todoProcessor.findAll();
		var todoDtoList = todoItemMapper.todoItemToTodoItemDto(todoList);
		return ResponseEntity.ok(todoDtoList);
	}
}
