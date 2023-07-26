package pl.spring.training.todo.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pl.spring.training.todo.commons.Adapter;
import pl.spring.training.todo.domain.TodoItem;
import pl.spring.training.todo.domain.TodoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Transactional(propagation = Propagation.MANDATORY)
@Adapter
@RequiredArgsConstructor
public class JpaTodoRepositoryAdapter implements TodoRepository {

    private final JpaTodoRepository todoRepository;
    private final JpaTodoPersistenceMapper mapper;

    @Override
    public TodoItem save(final TodoItem todoItem) {
        var todoEntity = mapper.todoItemToTodoEntity(todoItem);
        return mapper.todoEntityToTodoItem(todoRepository.save(todoEntity));
    }

    @Override
    public TodoItem getById(final String id) {
        return mapper.todoEntityToTodoItem(todoRepository.getReferenceById(id));
    }

    @Override
    public List<TodoItem> findAll() {
        return todoRepository.findAll().stream().map(mapper::todoEntityToTodoItem).collect(Collectors.toList());
    }

    @Override
    public TodoItem update(final TodoItem todoItem, final String id) {
        TodoEntity todoEntity = todoRepository.findById(id).orElseThrow(TodoNotFoundException::new);
        todoEntity.setDone(todoItem.isDone());
        todoEntity.setName(todoItem.getName());
        return mapper.todoEntityToTodoItem(todoRepository.save(todoEntity));
    }

    @Override
    public void delete(final String id) {
        todoRepository.deleteById(id);
    }
}
