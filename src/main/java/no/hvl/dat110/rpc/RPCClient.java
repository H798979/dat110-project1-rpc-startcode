package no.hvl.dat110.rpc;

import no.hvl.dat110.TODO;
import no.hvl.dat110.messaging.*;

public class RPCClient {

	// underlying messaging client used for RPC communication
	private MessagingClient msgclient;

	// underlying messaging connection used for RPC communication
	private MessageConnection connection;
	
	public RPCClient(String server, int port) {
	
		msgclient = new MessagingClient(server,port);
	}
	
	public void connect() {
		
		connection = msgclient.connect();
		
		if (true)
			throw new UnsupportedOperationException(TODO.method());
		
	}
	
	public void disconnect() {
		
		if(connection != null) {
			connection.close();
		}
		
		if (true)
			throw new UnsupportedOperationException(TODO.method());
		
	}

	/*
	 Make a remote call om the method on the RPC server by sending an RPC request message and receive an RPC reply message

	 rpcid is the identifier on the server side of the method to be called
	 param is the marshalled parameter of the method to be called
	 */

	public byte[] call(byte rpcid, byte[] param) {
		
		byte[] returnval = null;
		
		byte[] requestData = RPCUtils.encapsulate(rpcid, param);

		Message requestMsg = new Message(requestData);
		connection.send(requestMsg);

		Message replyMsg = connection.receive();

		if (replyMsg != null) {
			byte[] replyData = replyMsg.getData();
			returnval = RPCUtils.decapsulate(replyData);
		}



		if (true)
			throw new UnsupportedOperationException(TODO.method());
		
		// TODO - END
		return returnval;
		
	}

}
