package com.daxv.common.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author xu.da1
 * 全局异常捕获
 */
@Component
public class GlobalExceptionResolver implements HandlerExceptionResolver {
 
	public ModelAndView resolveException(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3) {
		ModelAndView mView = new ModelAndView("common/error.htm");
		return mView;
	} 
}
