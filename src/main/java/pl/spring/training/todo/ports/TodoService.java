package pl.spring.training.todo.ports;

import pl.spring.training.todo.domain.TodoItem;

public interface TodoService {

	TodoItem getById(String id);

	TodoItem create(TodoItem todoItem);
}
