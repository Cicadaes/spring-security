package com.auth.center.springsecurity.common.base;

import com.auth.center.springsecurity.common.model.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理器
 */
@RestControllerAdvice
public class RRExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 处理自定义异常
	 */
	@ExceptionHandler(RException.class)
	public R handleRRException(RException e){

		return R.error(e.getCode()+"",e.getMsg());
	}

	@ExceptionHandler(Exception.class)
	public R handleException(Exception e){
		return R.error(e.getMessage());
	}
}
