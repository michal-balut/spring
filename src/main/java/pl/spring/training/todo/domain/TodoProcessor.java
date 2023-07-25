package pl.spring.training.todo.domain;

import java.util.Collections;
import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import pl.spring.training.todo.ports.TodoService;

@Log
@RequiredArgsConstructor
public class TodoProcessor implements TodoService {

	private final IdGenerator idGenerator;

	private final TodoRepository repository;

	@Override
	public TodoItem getById(String id) {
		return repository.getById(id);
	}

	@Override
	public TodoItem create(final TodoItem todoItem) {
		var newTodoItem = TodoItem.builder()
				.id(idGenerator.getNext())
				.name(todoItem.getName())
				.isDone(false)
				.build();
		repository.save(newTodoItem);
		return newTodoItem;
	}

	@Override
	public TodoItem update(final String id, final TodoItem todoItem) {
		return null;
	}

	@Override
	public List<TodoItem> findAll() {
		return Collections.emptyList();
	}

}
