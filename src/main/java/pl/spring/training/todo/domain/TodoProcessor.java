package pl.spring.training.todo.domain;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import pl.spring.training.todo.ports.TodoService;

import java.util.List;

@Log
@RequiredArgsConstructor
public class TodoProcessor implements TodoService {

    private final IdGenerator idGenerator;

    private final TodoRepository repository;

    @Override
    @Transactional
    public TodoItem getById(String id) {
        return repository.getById(id);
    }

    @Override
    @Transactional
    public TodoItem create(final TodoItem todoItem) {
        var newTodoItem = TodoItem.builder()
            .id(idGenerator.getNext())
            .name(todoItem.getName())
            .done(false)
            .build();
        repository.save(newTodoItem);
        return newTodoItem;
    }

    @Override
    @Transactional
    public TodoItem update(final String id, final TodoItem todoItem) {
        return null;
    }

    @Override
    @Transactional
    public List<TodoItem> findAll() {
        return repository.findAll();
    }

}
