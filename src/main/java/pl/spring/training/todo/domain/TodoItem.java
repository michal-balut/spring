package pl.spring.training.todo.domain;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class TodoItem {

	String id;

	String name;

	boolean done;

}
