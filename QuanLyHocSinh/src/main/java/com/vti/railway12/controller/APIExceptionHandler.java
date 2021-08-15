//package com.vti.railway12.controller;
//
//import java.util.NoSuchElementException;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.context.request.WebRequest;
//
//import com.vti.railway12.form.ErrorMesage;
//
//@RestControllerAdvice
//public class APIExceptionHandler {
//
//	/*
//	 * Tất cả các exception không được khai báo sẽ được xử lý tại đây
//	 */
//	
//	@ExceptionHandler(Exception.class)
//	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
//	public ErrorMesage handleAllException(Exception ex, WebRequest request) {
//		// qua trinh kiem soat loi dien ra ow day
//		return new ErrorMesage(10000, ex.getLocalizedMessage());
//	}
//	
//	/*
//	 * No such exception sẽ được xử lý riêng tại đây
//	 */
//		
//	@ExceptionHandler(NoSuchElementException.class)
//	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
//	public ErrorMesage TodoException(Exception ex, WebRequest request) {
//		return new ErrorMesage(6969, "Đối tượng không tồn tại");
//	}
//	
//	/*
//	 * ArithmeticException exception sẽ được xử lý riêng tại đây
//	 */
//	
//	@ExceptionHandler(ArithmeticException.class)
//	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
//	public ErrorMesage DivideByZeroException(Exception ex, WebRequest request) {
//		return new ErrorMesage(11000, "Không thể chia cho 0");
//	}
//}
