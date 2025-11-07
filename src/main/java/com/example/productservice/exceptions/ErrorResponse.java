package com.example.productservice.exceptions;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorResponse {
	
	private HttpStatus status;
    private String message;
    private LocalDateTime timestamp;
    private List<String> errors;
    

	public ErrorResponse(HttpStatus status, String message, LocalDateTime timestamp) {
		super();
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


    
	  

}
