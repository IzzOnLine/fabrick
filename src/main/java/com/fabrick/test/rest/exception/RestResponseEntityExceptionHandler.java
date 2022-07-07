package com.fabrick.test.rest.exception;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler
	protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
		String message = ex.getMessage();
		String retVal = StringUtils.substringBetween(message, "description\":\"", "\",\"");
		retVal = StringUtils.substringBetween(message, "\"description\" : \"", "\",");
		if(!StringUtils.isNotBlank(retVal)) retVal = message;
		return handleExceptionInternal(ex, retVal, new HttpHeaders(), HttpStatus.I_AM_A_TEAPOT, request);
	}
}
