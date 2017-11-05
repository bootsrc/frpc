package org.flylib.frpc.protocal.encode;

import java.nio.ByteOrder;

import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

public class NettyMessageDecoder extends LengthFieldBasedFrameDecoder {

	public NettyMessageDecoder(ByteOrder byteOrder, int maxFrameLength, int lengthFieldOffset, int lengthFieldLength,
			int lengthAdjustment, int initialBytesToStrip, boolean failFast) {
		super(byteOrder, maxFrameLength, lengthFieldOffset, lengthFieldLength, lengthAdjustment, initialBytesToStrip, failFast);
		// TODO Auto-generated constructor stub
	}
	
}
