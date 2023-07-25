package pl.spring.training.todo.rest;

import lombok.Data;

@Data
public class UpdatedTodoDto {

	private String name;

	private boolean isDone;
}
