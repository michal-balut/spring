package pl.spring.training.todo.domain;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class TodoItem {

	private String id;

	private String name;

	private boolean isDone;

}
