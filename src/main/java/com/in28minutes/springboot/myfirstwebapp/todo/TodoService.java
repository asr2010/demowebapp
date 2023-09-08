package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	
	static private List<Todo> todos = new ArrayList<Todo>();
	
	static {
		todos.add(new Todo(1,"arpit", "Learn AWS", LocalDate.now().plusYears(1),false));
		todos.add(new Todo(2,"arpit", "Learn DevOps", LocalDate.now().plusYears(2),false));
		todos.add(new Todo(3,"arpit", "Learn FullStack", LocalDate.now().plusYears(3),false));
	}
	
	public List<Todo> findByUsername(String username){
		return todos;
	}
	
}
