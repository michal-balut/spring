package pl.spring.training.todo.ports;

import java.util.List;

import pl.spring.training.todo.domain.TodoItem;

public interface TodoService {

	TodoItem getById(String id);

	TodoItem create(TodoItem todoItem);

	TodoItem update(TodoItem todoItem);

	List<TodoItem> findAll();
}
