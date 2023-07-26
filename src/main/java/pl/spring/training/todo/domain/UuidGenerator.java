package pl.spring.training.todo.domain;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UuidGenerator implements IdGenerator {

    @Override
    public String getNext() {
        return UUID.randomUUID().toString();
    }

}
