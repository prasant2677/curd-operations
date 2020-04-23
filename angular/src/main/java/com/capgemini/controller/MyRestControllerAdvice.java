package com.capgemini.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.beans.ProductResponse;
import com.capgemini.exception.ProductException;

@RestControllerAdvice
public class MyRestControllerAdvice {
	@ExceptionHandler
	public ProductResponse myExceptionHandler(ProductException empEx) {
	ProductResponse response = new ProductResponse();
	response.setError(true);
	response.setMessage(empEx.getMessage());
	return response;
	}

}
