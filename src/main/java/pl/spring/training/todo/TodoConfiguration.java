package pl.spring.training.todo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.spring.training.todo.domain.*;

@Configuration
public class TodoConfiguration {

    @Bean
    public TodoProcessor todoProcessor(IdGenerator idGenerator, TodoRepository todoRepository) {
        return new TodoProcessor(idGenerator, todoRepository);
    }
}
