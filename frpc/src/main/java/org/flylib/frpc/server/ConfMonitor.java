package org.flylib.frpc.server;

import java.util.HashMap;
import java.util.Map;

import org.flylib.frpc.service.impl.HelloImpl;

/**
 * 模拟配置，实际的框架中大部分都是使用xml进行配置的，比如Hessian是配置在web.xml的servlet属性里的
 * @author Frank Liu(liushaomingdev@163.com)
 *
 */
public class ConfMonitor {
	public static final Map<String, Class<?>> conf = new HashMap<String, Class<?>>();
	
	static {
		conf.put("org.flylib.frpc.service.IHello", HelloImpl.class);
	}
}
