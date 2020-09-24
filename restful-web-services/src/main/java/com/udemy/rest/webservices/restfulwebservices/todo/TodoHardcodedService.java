package com.udemy.rest.webservices.restfulwebservices.todo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoHardcodedService {

	public static List<Todo> todos = new ArrayList();
	public static long idCounter=0;
	
	static {
			todos.add(new Todo(++idCounter,"Iphone",true,"Jana",5));
			todos.add(new Todo(++idCounter,"Samsung",true,"Jana",4));
			todos.add(new Todo(++idCounter,"Oneplus",true,"Jana",3));
			todos.add(new Todo(++idCounter,"Redmi",true,"Jana",2));
			todos.add(new Todo(++idCounter,"Blueberry",true,"Jana",1));
	}
	public List<Todo> findAll(){
		return todos;
	}
	
	public Todo save(Todo todo) {
		if(todo.getId()==-1 ||todo.getId()==0) {
			todo.setId(++idCounter);
			todos.add(todo);
		}else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
		
	}
	
	public Todo deleteById(long id) {
		Todo todo= findById(id);
		if(todo == null)
			return null;
		todos.remove(todo);
		return todo;
	}

	public Todo findById(long id) {
		// TODO Auto-generated method stub
		for(Todo todol:todos) {
			if (todol.getId() == id) {
				return todol;
			}
		}
		return null;
	}
}
