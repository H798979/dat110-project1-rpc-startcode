package no.hvl.dat110.messaging;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import no.hvl.dat110.TODO;

public class MessagingServer {

	// server-side socket for accepting incoming TCP connections
	private ServerSocket welcomeSocket;

	public MessagingServer(int port) {

		try {

			this.welcomeSocket = new ServerSocket(port);

		} catch (IOException ex) {

			System.out.println("Messaging server: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	
	public MessageConnection accept() {

		MessageConnection connection = null;

		try {

			Socket socket = welcomeSocket.accept();			//bíða eftir að client tengist

			connection = new MessageConnection(socket);		//búum til tegningu

		} catch(IOException e) {
			e.printStackTrace();
		}


		if (true)
			throw new UnsupportedOperationException(TODO.method());
		
		
		return connection;

	}

	public void stop() {

		if (welcomeSocket != null) {

			try {
				welcomeSocket.close();
			} catch (IOException ex) {

				System.out.println("Messaging server: " + ex.getMessage());
				ex.printStackTrace();
			}
		}
	}

}
