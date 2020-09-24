package com.udemy.rest.webservices.restfulwebservices.todo;

import java.net.URI;
import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin
@RestController
public class TodoResources {
	
	//service
	@Autowired
	public TodoHardcodedService todoService;
	
	@GetMapping(path="/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username){		
		return todoService.findAll();		
	}
	
	@GetMapping(path="/users/{username}/todos//{id}")
	public Todo getTodo(@PathVariable String username, @PathVariable long id ){		
		return todoService.findById(id);		
	}
	
	@DeleteMapping(path="/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id ){
		Todo todo = todoService.deleteById(id);
		if(todo != null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();		
	}
	
	@PutMapping(path="/users/{username}/todos/{id}")
	public ResponseEntity<Todo> UpdateTodo(@PathVariable String username, @PathVariable long id, @RequestBody Todo todo ){
		Todo updateTodo = todoService.save(todo);
		if(todo != null) {
			return new ResponseEntity<Todo>(todo, HttpStatus.OK);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping(path="/users/{username}/todos")
	public ResponseEntity<Todo> createTodo(@PathVariable String username, @RequestBody Todo todo ){
		Todo createTodo = todoService.save(todo);
		//location of uri
		URI uri= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createTodo.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}