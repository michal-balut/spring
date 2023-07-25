package pl.spring.training.todo.rest;

import lombok.Data;

@Data
public class TodoItemDto {

	private String id;

	private String name;

	private boolean isDone;
}
