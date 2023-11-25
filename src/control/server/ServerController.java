package control.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerController extends Thread {
    private ServerSocket server; 
	private Socket request;
	
	public ServerController() { 
		try { 
			server = new ServerSocket(8080, 50); 
			System.out.println("[server]: server on!"); 
			this.start();
		} catch (IOException e) { e.printStackTrace(); } 
	}

    public void run() { 
		try { 
			while (true) { 
				request = server.accept();
				new SideWorker(request); 
			} 
		} catch (IOException e) { e.printStackTrace(); } 
	}
}