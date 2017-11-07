package org.flylib.frpc.protocal.constant;

//public class MessageType {
//	public static class LOGIN_REQ {
//		public static byte value() {
//			return 1;
//		}
//	}
//	
//	public static class LOGIN_RESP {
//		public static byte value() {
//			return 2;
//		}
//	}
//}


public enum MessageType {

    // 利用构造函数传参

	LOGIN_REQ((byte)0x1), LOGIN_RESP((byte)0x2), HEARTBEAT_RESP((byte) 0x3), HEARTBEAT_REQ((byte) 0x4);

    // 定义私有变量

    private byte value;

    // 构造函数，枚举类型只能为私有

    private MessageType(byte value) {

        this.value = value;

    }

    @Override
    public String toString() {

        return String.valueOf(this.value);

    }
    
    public byte value() {
    	return value;
    }
}
