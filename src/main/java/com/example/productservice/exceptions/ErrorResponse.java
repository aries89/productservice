package com.example.productservice.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatusCode;


public class ErrorResponse {
	
	private HttpStatusCode status;
    private String message;
    private LocalDateTime timestamp;
    
	public ErrorResponse(HttpStatusCode status, String message, LocalDateTime timestamp) {
		super();
		this.status = status;
		this.message = message;
		this.timestamp = timestamp;
	}

	public HttpStatusCode getStatus() {
		return status;
	}

	public void setStatus(HttpStatusCode status) {
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
	
	
    
    

}
