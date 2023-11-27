package control.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import model.Method;
import model.Request;
import model.Response;

public class ClientController extends Thread {
    private Socket conn = null;
	private ObjectInputStream input;
	private ObjectOutputStream output;
	private Response response;
	
	public ClientController() {
        connectToServer();
		try {
            output = new ObjectOutputStream(conn.getOutputStream());
            input = new ObjectInputStream(conn.getInputStream());
            response = new Response(null);
        } catch (Exception e) { e.printStackTrace(); } 
        start();
	}

    private void connectToServer() {
        boolean connected = false;
		while (!connected) {
			try {  
				conn = new Socket(InetAddress.getLocalHost(), 8080);
				System.out.println(conn);
				connected = true;
			} catch (IOException e) {
				System.out.println("[client]: connection failed, restarting...");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			} 
		}
    }

    public void run() { 
		try { 
			do {
                response = (Response) input.readObject();
                System.out.println(response.getMessage());
			} while (response.getMethod() != Method.END);

            System.out.println("[client]: connection closed...");
            input.close();
            output.close();
            conn.close();
            System.exit(0);
		} catch (Exception e) { e.printStackTrace(); } 
	}

	public void sendRequest(Request request) {
        try {
            output.writeObject(request);
        } catch (Exception e) { e.printStackTrace(); } 
    }
}