package org.flylib.frpc.protocal.handler;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.flylib.frpc.protocal.constant.MessageType;
import org.flylib.frpc.protocal.model.Header;
import org.flylib.frpc.protocal.model.NettyMessage;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class HeartBeatReqHandler extends ChannelInboundHandlerAdapter {
	private volatile ScheduledFuture<?> heartBeat;
	
	@Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        NettyMessage message = (NettyMessage)msg;
        // 握手成功， 主动发送心跳信息
        if (message.getHeader() != null && message.getHeader().getType() == MessageType.LOGIN_RESP.value()) {
        	heartBeat = ctx.executor().scheduleAtFixedRate(new HeartBeatReqHandler.HeartBeatTask(ctx), 0, 5000, TimeUnit.MILLISECONDS);
        }  else if (message.getHeader() != null && message.getHeader().getType() == MessageType.HEARTBEAT_RESP.value()) {
        	System.out.println("Client receive server heart beat message : ---> " + message);
        } else {
        	ctx.fireChannelRead(msg);
        }
    }
	
	@Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        if (heartBeat != null) {
        	heartBeat.cancel(true);
        	heartBeat = null;
        }
        ctx.fireExceptionCaught(cause);
    }

	private class HeartBeatTask implements Runnable {
		private final ChannelHandlerContext ctx;

		public HeartBeatTask(ChannelHandlerContext ctx) {
			this.ctx = ctx;
		}

		@Override
		public void run() {
			NettyMessage heartBeat = buildHeartBeat();
			System.out.println("Client send heart beat message to server : ---> " + heartBeat);
			ctx.writeAndFlush(heartBeat);
		}
		
		private NettyMessage buildHeartBeat() {
			NettyMessage message = new NettyMessage();
			Header header= new Header();
			header.setType(MessageType.HEARTBEAT_REQ.value());
			message.setHeader(header);
			return message;
		}
	}
}
