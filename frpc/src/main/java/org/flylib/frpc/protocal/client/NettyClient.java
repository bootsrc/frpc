package org.flylib.frpc.protocal.client;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

public class NettyClient {
	private ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
	EventLoopGroup group = new NioEventLoopGroup();
	
	public void connect(int port, String host) throws Exception {
		// 配置客户端NIO线程组
		try {
			
		} finally {
			
		}
	}
}
