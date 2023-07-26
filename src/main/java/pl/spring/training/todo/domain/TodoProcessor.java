package pl.spring.training.todo.domain;

import java.util.List;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import pl.spring.training.todo.ports.TodoService;

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
		var updatedTodoItem = TodoItem.builder()
				.id(id)
				.name(todoItem.getName())
				.done(todoItem.isDone())
				.build();
		repository.update(updatedTodoItem, id);
		return updatedTodoItem;
    }

    @Override
    @Transactional
    public List<TodoItem> findAll() {
        return repository.findAll();
    }

}
