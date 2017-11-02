package org.flylib.frpc.protocal.encode;

import java.io.IOException;
import java.util.List;

import org.flylib.frpc.protocal.model.NettyMessage;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

public final class NettyMessageEncoder extends MessageToMessageEncoder<NettyMessage> {
	MarshallingEncoder marshallingEncoder;
	
	public NettyMessageEncoder() throws IOException {
		this.marshallingEncoder = new MarshallingEncoder();
	}

	protected void encode(ChannelHandlerContext ctx, NettyMessage msg, List<Object> out) throws Exception {
		
	}
}
