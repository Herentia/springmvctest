package com.pb.porxytest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class MyInvokationHandler implements InvocationHandler {
	//��Ҫ������Ķ���
	private Object target;
	
	public MyInvokationHandler(Object target) {
		super();
		this.target = target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		TxUtil txUtil = new TxUtil();
		txUtil.beginTx();
		System.out.println(method.getName() + "---" + Arrays.toString(args));
		Object result =  method.invoke(target, args);
		txUtil.afterTx();
		return result;
	}
	
	public Object getProxy() {
		ClassLoader loader = target.getClass().getClassLoader();
		Class<Object>[] interfaces = (Class<Object>[]) target.getClass().getInterfaces();
		Object proxy = Proxy.newProxyInstance(loader, interfaces, this);
		return proxy;
	}

}
