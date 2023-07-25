package pl.spring.training.todo.domain;

import java.util.List;

public interface TodoRepository {

    TodoItem save(TodoItem todoItem);
    TodoItem getById(String id);
    List<TodoItem> findAll();
    TodoItem update(TodoItem todoItem, String id);
    void delete(String id);
}
