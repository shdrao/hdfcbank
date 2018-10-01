package com.capgemini.hdfcbank.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value= Exception.class)
	public String handleError(HttpServletRequest request, Exception exception) {
		System.out.println(exception);
		request.setAttribute("success",false);
		request.setAttribute("error", exception.getMessage());
		return "success";
	}
}
