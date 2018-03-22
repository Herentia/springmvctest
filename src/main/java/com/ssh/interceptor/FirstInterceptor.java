package com.ssh.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class FirstInterceptor implements HandlerInterceptor {

	/**
	 * 在目标方法之前被调用
	 * 如果返回值为true，则继续调用后续拦截器和目标方法
	 * 若返回值为false，则不会调用后续的拦截器和方法
	 * 
	 * 可以考虑做权限，日志，事务等
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("preHandle");
		return true;
	}

	/**
	 * 调用目标之后，渲染视图之前调用
	 * 
	 * 可以对请求域中的属性或视图做出修改
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle");

	}

	/**
	 * 渲染视图之后被调用
	 * 
	 * 用作释放资源
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion");
	}

}
