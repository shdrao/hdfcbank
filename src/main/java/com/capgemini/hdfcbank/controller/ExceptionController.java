package com.capgemini.hdfcbank.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.capgemini.hdfcbank.exceptions.LowBalanceException;
import com.capgemini.hdfcbank.exceptions.PasswordChangeFailedException;
import com.capgemini.hdfcbank.exceptions.UpdationFailedException;
import com.capgemini.hdfcbank.exceptions.UserNotFoundException;

@ControllerAdvice
public class ExceptionController {

//	@ExceptionHandler(value = Exception.class)
//	public String handleError(HttpServletRequest request, Exception exception) {
//		System.out.println(exception);
//		request.setAttribute("success", false);
//		request.setAttribute("error", exception.getMessage() + request.getRequestURI());
//		return "success";
//	}

	@ExceptionHandler(value = UserNotFoundException.class)
	public String handlheError(HttpServletRequest request, UserNotFoundException exception) {
		System.out.println(exception);
		request.setAttribute("success", false);
		request.setAttribute("error", exception);
		System.out.println(exception.getCause());
		return "success";
	}

	@ExceptionHandler(value = LowBalanceException.class)
	public String handlheErrorf(HttpServletRequest request, LowBalanceException exception) {
		System.out.println(exception);
		request.setAttribute("success", false);
		request.setAttribute("error", exception);
		System.out.println(exception.getCause());
		return "success";
	}

	@ExceptionHandler(value = PasswordChangeFailedException.class)
	public String handlheErrorf(HttpServletRequest request, PasswordChangeFailedException exception) {
		System.out.println(exception);
		request.setAttribute("success", false);
		request.setAttribute("error", exception);
		System.out.println(exception.getCause());
		return "success";
	}

	@ExceptionHandler(value = UpdationFailedException.class)
	public String handlheErrorf(HttpServletRequest request, UpdationFailedException exception) {
		System.out.println(exception);
		request.setAttribute("success", false);
		request.setAttribute("error", exception);
		System.out.println(exception.getCause());
		return "success";
	}
	@ExceptionHandler(value = SQLException.class)
	public String handlheErrorf(HttpServletRequest request, SQLException exception) {
		System.out.println(exception);
		request.setAttribute("success", false);
		request.setAttribute("error", exception);
		System.out.println(exception.getCause());
		return "success";
	}
}
