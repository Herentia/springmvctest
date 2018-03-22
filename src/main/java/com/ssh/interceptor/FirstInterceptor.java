package com.ssh.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class FirstInterceptor implements HandlerInterceptor {

	/**
	 * ��Ŀ�귽��֮ǰ������
	 * �������ֵΪtrue����������ú�����������Ŀ�귽��
	 * ������ֵΪfalse���򲻻���ú������������ͷ���
	 * 
	 * ���Կ�����Ȩ�ޣ���־�������
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("preHandle");
		return true;
	}

	/**
	 * ����Ŀ��֮����Ⱦ��ͼ֮ǰ����
	 * 
	 * ���Զ��������е����Ի���ͼ�����޸�
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle");

	}

	/**
	 * ��Ⱦ��ͼ֮�󱻵���
	 * 
	 * �����ͷ���Դ
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion");
	}

}
