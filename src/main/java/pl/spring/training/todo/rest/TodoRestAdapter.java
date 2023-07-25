package pl.spring.training.todo.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pl.spring.training.todo.ports.TodoService;

@RequestMapping("todos")
@RestController
@RequiredArgsConstructor
public class TodoRestAdapter {

	private TodoService todoService;

	private TodoItemMapper todoItemMapper;

	@GetMapping("{id}")
	public ResponseEntity<TodoItemDto> getById(@PathVariable String id) {
		var todoItem = todoService.getById(id);
		var todoItemDto = todoItemMapper.toDto(todoItem);
		return ResponseEntity.ok(todoItemDto);
	}

	@PutMapping("{id}")
	public ResponseEntity<TodoItemDto> updateById(@PathVariable String id, @RequestBody UpdatedTodoDto updatedTodoDto) {
		var todoItem = todoItemMapper.toDomain(id, updatedTodoDto);
		var updatedTodoItem = todoService.update(todoItem);
		var updatedTodoItemDto = todoItemMapper.toDto(updatedTodoItem);
		return ResponseEntity.ok(updatedTodoItemDto);
	}

	@PostMapping
	public ResponseEntity<TodoItemDto> create(@RequestBody NewTodoDto newTodoDto) {
		var todoItem = todoItemMapper.toDomain(newTodoDto);
		var createdTodoItem = todoService.create(todoItem);
		var todoItemDto = todoItemMapper.toDto(createdTodoItem);
		return ResponseEntity.status(HttpStatus.CREATED).body(todoItemDto);
	}

	@GetMapping
	public ResponseEntity<List<TodoItemDto>> list() {
		var todoList = todoService.findAll();
		var todoDtoList = todoItemMapper.toList(todoList);
		return ResponseEntity.ok(todoDtoList);
	}
}