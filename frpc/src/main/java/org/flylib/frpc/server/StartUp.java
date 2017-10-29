package org.flylib.frpc.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * RPC服务器启动
 * @author Frank Liu(liushaomingdev@163.com)
 *
 */
public class StartUp {
	public static final int port = 8080;
	
	public static void main(String[] args) {
			exportRpc();
	}
	
	/**
	 * 导出RPC接口
	 */
	private static void exportRpc() {
		try {
			ServerSocket ss = new ServerSocket(9001);
			while(true){
				Socket s = ss.accept();
				new RpcThread(s).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
