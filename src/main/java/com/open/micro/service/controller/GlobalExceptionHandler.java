package com.open.micro.service.controller;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.open.micro.service.model.Result;

@ControllerAdvice(basePackages={"com.open.server.rest"})
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	private static final Logger LOGGER = LoggerFactory.getLogger( GlobalExceptionHandler.class );
	
	@ExceptionHandler(value={Exception.class, Throwable.class})
	@ResponseBody
	Result handlerAllException( HttpServletRequest request, Throwable ex){
		StringWriter sw = new StringWriter();
		ex.printStackTrace(new PrintWriter(sw));
		LOGGER.error( sw.toString() );
		return Result.createFail("internal error:" + ex.getClass().getSimpleName());
	}
	
}