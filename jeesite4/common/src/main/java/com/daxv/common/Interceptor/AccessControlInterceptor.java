package com.daxv.common.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.daxv.common.Identity.AuthUtil;
import com.daxv.common.Vo.UserEntity;
 
  
/**
 * @author xu.da1
 * 用户授权验证
 */
public class AccessControlInterceptor extends  HandlerInterceptorAdapter {
	private int openingTime;
	private int closingTime;
	 
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception { 
 		try { 
	        UserEntity userEntity =(UserEntity)  AuthUtil.getUserInfo(request); 
			if(userEntity==null){    
				response.sendRedirect("/WebUIByH/User/login.htm");
				return false;
			} 
		} 
 		catch (Exception e) {
			response.sendRedirect("/WebUIByH/User/login.htm");
		} 
		return true;	 
	}  
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {  
	} 
	
  
	public int getOpeningTime() {
		return openingTime;
	}

	public void setOpeningTime(int openingTime) {
		this.openingTime = openingTime;
	}

	public int getClosingTime() {
		return closingTime;
	}

	public void setClosingTime(int closingTime) {
		this.closingTime = closingTime;
	}
	
}
