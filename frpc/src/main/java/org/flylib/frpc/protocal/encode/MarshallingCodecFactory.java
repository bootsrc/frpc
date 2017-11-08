package org.flylib.frpc.protocal.encode;

import java.io.IOException;

import org.jboss.marshalling.Marshaller;
import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.Marshalling;
import org.jboss.marshalling.MarshallingConfiguration;
import org.jboss.marshalling.Unmarshaller;
import org.jboss.marshalling.serial.SerialMarshallerFactory;

public class MarshallingCodecFactory {
	/** 
     * 创建Jboss Marshaller 
     * @throws IOException 
     */  
    protected static Marshaller buildMarshalling() throws IOException {  
        final MarshallerFactory marshallerFactory = Marshalling.getProvidedMarshallerFactory("serial");  
//    	final MarshallerFactory marshallerFactory = new SerialMarshallerFactory();
        final MarshallingConfiguration configuration = new MarshallingConfiguration();  
        configuration.setVersion(5);  
        Marshaller marshaller = marshallerFactory.createMarshaller(configuration);  
        return marshaller;  
    }  
  
    /** 
     * 创建Jboss Unmarshaller 
     * @throws IOException 
     */  
    protected static Unmarshaller buildUnMarshalling() throws IOException {  
        final MarshallerFactory marshallerFactory = Marshalling.getProvidedMarshallerFactory("serial");
//    	final MarshallerFactory marshallerFactory = new SerialMarshallerFactory();
        final MarshallingConfiguration configuration = new MarshallingConfiguration();  
        configuration.setVersion(5);  
        Unmarshaller unmarshaller = marshallerFactory.createUnmarshaller(configuration);  
        return unmarshaller;  
    }  
}
