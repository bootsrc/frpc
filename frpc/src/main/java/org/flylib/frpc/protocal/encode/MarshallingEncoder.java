package org.flylib.frpc.protocal.encode;

import java.io.IOException;

import javax.xml.bind.Marshaller;

public class MarshallingEncoder {
	private static final byte[] LENGTH_PLACEHOLDER = new byte[4];
	Marshaller marshaller; 
	public MarshallingEncoder() throws IOException {
		marshaller = MarshallingCoderFactory.buildMarshalling();
	}
	
	
}
