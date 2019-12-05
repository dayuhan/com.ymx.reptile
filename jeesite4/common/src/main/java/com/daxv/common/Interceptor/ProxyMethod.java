package com.daxv.common.Interceptor;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.daxv.common.Vo.StudentEntity;
 
/**
 * @author xu.da1
 *
 */
@Aspect
@Component
public class ProxyMethod {
	/**
	 * 拦截业务层
	 * 
	 */
	@Pointcut("execution(public boolean  Com.Shared.Services.*.*Student(*))&&args(stu)")
	public void doFilter(StudentEntity stu) {
	}

	@Before(value = "doFilter(stu)", argNames = "stu")
	public void BeforeMethod(StudentEntity stu) {
		System.out.println("-----------拦截成功-----------"); 
		System.out.println(String.format("名称：%S,年龄：%d", stu.getNameString(),stu.getAge()));
	}

	@AfterReturning(value = "doFilter(stu)", argNames = "stu")
	public void AfterReturningMethod(StudentEntity stu) {
		System.out.println("-----------执行完毕！-------------"); 
	}

	@AfterThrowing(pointcut = "doFilter(stu)", throwing = "ex")
	public void AfterThrowingMethod(Exception ex, StudentEntity stu) {
		System.out.println(String.format("异常信息：%S", ex.getMessage()));
	}

	/**
	 * 拦截控制器
	 */
	@Pointcut("execution(public * Com.Shared.Controller.*.*Controller(..))")
	public void doFilter2() {} 
	
	@Before("doFilter2()")
	public void BeforeMethod2() {
		System.out.println("-----------拦截成功11111-----------");
		//System.out.println(String.format("拦截参数：姓名：%s 年龄：%d", stu.getNameString(),stu.getAge()));
	}
	@AfterReturning("execution(public * com.Shared.Controller.*.*Test())")
	public void AfterReturningMethod()
	{
		System.out.println("-----------拦截后执行1111-----------");
	} 
	
	@Pointcut("execution(public * Com.Shared.Controller.*.*Controller(*))&&args(stu)")
	public void doFilter3(StudentEntity stu) {}
	
	@Before(value="doFilter3(stu)",argNames="stu")
	public void BeforeMethod3(StudentEntity stu) {
		System.out.println("-----------拦截成功2222-----------");
		System.out.println(String.format("拦截参数：姓名：%s 年龄：%d", stu.getNameString(),stu.getAge()));
	} 
}
