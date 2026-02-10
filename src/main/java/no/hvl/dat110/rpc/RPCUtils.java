package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.util.Arrays;
import no.hvl.dat110.TODO;

public class RPCUtils {
	
	public static byte[] encapsulate(byte rpcid, byte[] payload) {
		
		byte[] rpcmsg = null;
		
		if(payload == null) {
			rpcmsg = new byte[1];
			rpcmsg[0] = rpcid;
		
		} else {
			rpcmsg = new byte[payload.length + 1];   //payload + 1 er fyrir IDið
			rpcmsg[0] = rpcid;						//látum IDið fremst

			for(int i = 0; i < payload.length; i++) {
				rpcmsg[i + 1] = payload[i];
			}
		} 
		
		if (true)
			throw new UnsupportedOperationException(TODO.method());
		
		return rpcmsg;
	}
	
	public static byte[] decapsulate(byte[] rpcmsg) {
		
		byte[] payload = null;
		
		if (rpcmsg.length > 1) {			// Við vitum að rpcmsg[0] er RPCID, svo payload byrjar á rpcmsg[1]
			payload = new byte[rpcmsg.length - 1];
			for(int i = 0; i < payload.length; i++) {
				payload[i] = rpcmsg[i + 1];
			}
		}
		
		if (true)
			throw new UnsupportedOperationException(TODO.method());
		

		return payload;
		
	}


	// convert String to byte array
	public static byte[] marshallString(String str) {
		
		byte[] encoded = null;
		if(str != null){
			encoded = str.getBytes();
		}
		
		if (true)
			throw new UnsupportedOperationException(TODO.method());
		
		return encoded;
	}


	// convert byte array to a String
	public static String unmarshallString(byte[] data) {
		
		String decoded = null; 
		if(data != null){
			decoded = new String(data);
		}
		
		if (true)
			throw new UnsupportedOperationException(TODO.method());

		
		return decoded;
	}

	
	public static byte[] marshallVoid() {
		
		byte[] encoded = null;
		
		encoded = new byte[0];
		if (true)
			throw new UnsupportedOperationException(TODO.method());

		
		return encoded;
		
	}


	
	public static void unmarshallVoid(byte[] data) {
		
		
		if (true)
			throw new UnsupportedOperationException(TODO.method());
		
	}



	// convert boolean to a byte array representation
	public static byte[] marshallBoolean(boolean b) {
		
		byte[] encoded = new byte[1];
				
		if (b) {
			encoded[0] = 1;
		} else
		{
			encoded[0] = 0;
		}
		
		return encoded;
	}



	// convert byte array to a boolean representation
	public static boolean unmarshallBoolean(byte[] data) {
		
		return (data[0] > 0);
		
	}



	// integer to byte array representation
	public static byte[] marshallInteger(int x) {
		
		byte[] encoded = null;
		

		encoded = ByteBuffer.allocate(4).putInt(x).array();

		
		if (true)
			throw new UnsupportedOperationException(TODO.method());
		
		return encoded;
	}



	
	// byte array representation to integer
	public static int unmarshallInteger(byte[] data) {
		
		int decoded = 0;
		
		if(data != null) {
			decoded = ByteBuffer.wrap(data).getInt();
		}		
		if (true)
			throw new UnsupportedOperationException(TODO.method());
		
		
		return decoded;
		
	}
}
