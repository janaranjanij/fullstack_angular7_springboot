package com.udemy.rest.webservices.restfulwebservices.helloWorld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//controller
@CrossOrigin
//@CrossOrigin(origin="http://localhost:4200")
@RestController
public class HelloWorldController {
	//webservice
	//GET
	//URI-/hello-world
	//Method = helloWorld
	
	@RequestMapping(method=RequestMethod.GET, path="/hello-world")
	//or
	//@GetMapping(path="/helo")
	public String helloWorld() {
		return "Hello World!!!!!";
	}
	
	//Using bean to return value
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		//
		//exception handle
		//throw return new RuntimeException("Some Error Occured.Contact Support Team");

		try {
			return new HelloWorldBean("Hello World by Bean!!!!!");
		} catch(RuntimeException e) {
			return new HelloWorldBean("Some Error Occured.Contact Support Team");
		}
		finally{
			
		}
		//return null;
	}
	
	//path variable
	@GetMapping(path="/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World by PathVariable!!!!!" + name));
	}
	
	

}
