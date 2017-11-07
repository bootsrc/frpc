package org.flylib.frpc;

import java.nio.ByteBuffer;

import org.flylib.frpc.client.ProxyFactory;
import org.flylib.frpc.service.IHello;

public class RpcClient {
	public static void main(String[] args) {
//		String ip = "localhost";
//		int port = 9001;
//		IHello hello = ProxyFactory.create(IHello.class, ip, port);
//		System.out.println(hello.sayHello("Frank Liu"));
		
		testMine();
	}
	
	private static void testMine() {
		ByteBuffer buffer = ByteBuffer.allocate(88);
		String value = "Netty权威指南";
		buffer.put(value.getBytes());
		buffer.flip();
		int len = buffer.remaining();
		System.out.println("len=" + len);
		byte[] vArray = new byte[len];
		buffer.get(vArray);
		String decodeValue = new String(vArray);
		System.out.println("decodeValue=" + decodeValue + "End_Here");
		
		System.out.println("-------------------------");
		buffer.put(value.getBytes());
		buffer.put(value.getBytes());
		int len1 = buffer.remaining();
		System.out.println("len=" + len1);
		byte[] vArray1 = new byte[len];
		buffer.get(vArray1);
		String decodeValue1 = new String(vArray1);
		System.out.println("decodeValue1=" + decodeValue1 + "End_Here");
	}
}
