package no.hvl.dat110.messaging;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import no.hvl.dat110.TODO;


public class MessageConnection {

	private DataOutputStream outStream; // for writing bytes to the underlying TCP connection
	private DataInputStream inStream; // for reading bytes from the underlying TCP connection
	private Socket socket; // socket for the underlying TCP connection
	
	public MessageConnection(Socket socket) {

		try {

			this.socket = socket;

			outStream = new DataOutputStream(socket.getOutputStream());

			inStream = new DataInputStream (socket.getInputStream());

		} catch (IOException ex) {

			System.out.println("Connection: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	public void send(Message message) {

		byte[] data;
		
		data = MessageUtils.encapsulate(message);		//pakkar skilaboðunum i segment

		try {

			outStream.write(data);						//sendir gögnin út 
			outStream.flush();							// tryggir að þau fari straks 

		} catch(IOException e) {
			e.printStackTrace();
		}
		
		if (true)
			throw new UnsupportedOperationException(TODO.method());

	}

	public Message receive() {

		Message message = null;
		byte[] data = new byte[MessageUtils.SEGMENTSIZE];
		
		try {

			inStream.readFully(data);						//tökum inn dataið fra skilaboðunum

			message = MessageUtils.decapsulate(data);		//pökkum upp gögnunum 

		} catch(IOException e) {
			e.printStackTrace();
		}

		
		if (true)
			throw new UnsupportedOperationException(TODO.method());
		

		return message;
		
	}
	
	public void close() {

		try {
			
			outStream.close();
			inStream.close();

			socket.close();
			
		} catch (IOException ex) {

			System.out.println("Connection: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}