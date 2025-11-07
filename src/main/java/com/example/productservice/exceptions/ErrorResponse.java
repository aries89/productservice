package com.example.productservice.exceptions;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;


public class ErrorResponse {
	
	private HttpStatus status;
    private String message;
    private LocalDateTime timestamp;
    private List<String> errors;
    
    
    

	public ErrorResponse() {
		super();
	}


	public ErrorResponse(HttpStatus status, String message, LocalDateTime timestamp) {
		
		this.status = status;
		this.message = message;
		this.timestamp = timestamp;
	}


	public ErrorResponse(HttpStatus status, String message, LocalDateTime timestamp, List<String> errors) {
		super();
		this.status = status;
		this.message = message;
		this.timestamp = timestamp;
		this.errors = errors;
	}


	public HttpStatus getStatus() {
		return status;
	}


	public void setStatus(HttpStatus status) {
		this.status = status;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public LocalDateTime getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}


	public List<String> getErrors() {
		return errors;
	}


	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
    
	
	
    
	

    
	  

}
