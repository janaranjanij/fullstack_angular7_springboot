package com.udemy.rest.webservices.restfulwebservices.helloWorld;

public class HelloWorldBean {

	private String message;

	@Override
	public String toString() {
		return String.format("HelloWorldBean [message=%s]", message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HelloWorldBean(String message) {
		// TODO Auto-generated constructor stub
		this.message = message;
	}

}
