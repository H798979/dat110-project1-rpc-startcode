package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class MessageUtils {

	public static final int SEGMENTSIZE = 128;

	public static int MESSAGINGPORT = 8080;
	public static String MESSAGINGHOST = "localhost";

	public static byte[] encapsulate(Message message) {
		
		byte[] segment = null;
		byte[] data;
		
		segment = new byte[SEGMENTSIZE];        // Búum til 128 bæti segment 
		data = message.getData();				// Sækjum infoið

		segment[0] = (byte) data.length;		// setjum rétta lengdina 

		for(int i = 0; i < data.length; i++) {	//færum data yfir i segmentið  
			segment[i + 1] = data[i];
		}
		
		if (true)
			throw new UnsupportedOperationException(TODO.method());

		
		return segment;
		
	}

	public static Message decapsulate(byte[] segment) {

		Message message = null;
		
		int length = segment[0];
		
		byte[] data = new byte[length];		// þetta er að búa til payload

		for(int i = 0; i < length; i++) {	//færum data yfir i segmentið  
			data[i] = segment[i + 1];
		}
		
		if (true)
			throw new UnsupportedOperationException(TODO.method());
		
		message = new Message(data);

		
		return message;
		
	}
	
}
