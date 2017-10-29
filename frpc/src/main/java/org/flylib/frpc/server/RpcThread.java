package org.flylib.frpc.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

public class RpcThread extends Thread {
	private Socket s;
	public RpcThread(Socket s) {
		this.s = s;
	}
	
	@Override
	public void run() {
		ObjectInputStream is = null;
		ObjectOutputStream os = null;
		try {
			is = new ObjectInputStream(s.getInputStream());
			// 得到远程调用参数，包含了接口名，调用方法，方法参数
			RpcObject rpcObject = (RpcObject) is.readObject();
			// 构建接口的实现类，然后通过反射调用方法
			Object o = getObject(rpcObject.getC());
			Object reO = executeMethod(o, rpcObject.getMethodName(), rpcObject.getArgs());
			
			// 输出返回值
			os = new ObjectOutputStream(s.getOutputStream());
			os.writeObject(reO);
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 通过反射技术执行方法，并返回返回值
	 * @param o
	 * @param methodName
	 * @param args
	 * @return
	 */
	private Object executeMethod(Object o, String methodName, Object[] args) {
		Object objR = null;
		Class[] cs = new Class[args.length];
		for (int i = 0; i < args.length; i++) {
			Object arg = args[i];
			cs[i] = arg.getClass();
		}
		try {
			Method m = o.getClass().getMethod(methodName, cs);
			objR = m.invoke(o, args);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return objR;
	}
	
	/**
	 * 根据接口名得到实例
	 * @param c
	 * @return
	 */
	private Object getObject(Class c) {
		Object o = null;
		try {
			o = ConfMonitor.conf.get(c.getName()).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return o;
	}
}
