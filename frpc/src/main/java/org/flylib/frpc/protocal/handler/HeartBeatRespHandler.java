package org.flylib.frpc.protocal.handler;

import org.flylib.frpc.protocal.constant.MessageType;
import org.flylib.frpc.protocal.model.Header;
import org.flylib.frpc.protocal.model.NettyMessage;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class HeartBeatRespHandler extends ChannelInboundHandlerAdapter {
	@Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        NettyMessage message = (NettyMessage)msg;
        // 返回心跳应答消息
        if (message.getHeader() != null && message.getHeader().getType() == MessageType.HEARTBEAT_REQ.value()) {
        	System.out.println("Receive clent heart beat message : ---> " + message);
        	NettyMessage heartBeat = buildHeartBeat();
        	System.out.println("Send heart beat response  message to client : ---> " + heartBeat);
        	ctx.writeAndFlush(heartBeat);
        }  else {
        	ctx.fireChannelRead(msg);
        }
    }
	
	private NettyMessage buildHeartBeat() {
		NettyMessage message = new NettyMessage();
		Header header= new Header();
		header.setType(MessageType.HEARTBEAT_RESP.value());
		message.setHeader(header);
		return message;
	}
}
