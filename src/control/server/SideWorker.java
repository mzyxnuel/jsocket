package control.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import model.Method;
import model.Request;
import model.Response;

public class SideWorker extends Thread {
    private Socket conn;
    private ObjectInputStream input;
	private ObjectOutputStream output;
    private Request request;

    public SideWorker(Socket connectionRequest) { acceptConnection(connectionRequest); }

    private void acceptConnection(Socket conn) {
        try {
			this.conn = conn;
			input = new ObjectInputStream(conn.getInputStream());
			output = new ObjectOutputStream(conn.getOutputStream());
            request = new Request(null, null);
            System.out.println("[server]: connection requested from: "+ conn.getInetAddress().toString() + ":" + conn.getPort());
			start();
		} catch (IOException e) { e.printStackTrace(); }
    }

    public void run() { 
        try {
            do {
                request = (Request) input.readObject();
                System.out.println("[server]: new request: " + request.getMethod());

                switch (request.getMethod()) {
                    case GET:
                        break;
                    case POST:
                        break;
                    case PUT:
                        break;
                    case PATCH:
                        break;
                    case DELETE:
                        break;
                    case OPTIONS:
                        break;

                    default: break;
                }

                output.writeObject(new Response(Method.OK, request.getMethod().toString()));
            } while(request.getMethod() != Method.END);

            output.writeObject(new Response(Method.END, "[server]: closing connection..."));
            conn.close(); 
            System.out.println("[server]: connection ended: " + conn.getInetAddress().toString() + ":" + conn.getPort());
        } catch (IOException e) { 
            System.out.println("[server]: client unexpectedly disconnected"); 
        } catch (ClassNotFoundException e) {
            System.out.println("[server]: corrupted class readed from client!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}
