package org.flylib.frpc.service.impl;

import org.flylib.frpc.service.IHello;

public class HelloImpl implements IHello {
	@Override
	public String sayHello(String name) {
		return "hello:" + name + ",111";
	}
}
