package com.springboot.demo.exception;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Data;
@Data
@JsonPOJOBuilder
public class ErrorResponse {

	    public ErrorResponse(String message, List<String> details) {
	        super();
	        this.message = message;
	        this.details = details;
	    }
	    public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public List<String> getDetails() {
			return details;
		}

		public void setDetails(List<String> details) {
			this.details = details;
		}
		private String message;
		 
	    private List<String> details;
	 
	 
	}

