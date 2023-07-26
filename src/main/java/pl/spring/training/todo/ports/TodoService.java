package pl.spring.training.todo.ports;

import pl.spring.training.todo.domain.TodoItem;

import java.util.List;

public interface TodoService {

	TodoItem getById(String id);

	TodoItem create(TodoItem todoItem);

	TodoItem update(String id, TodoItem todoItem);

	List<TodoItem> findAll();
}
