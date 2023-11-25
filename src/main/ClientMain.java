package main;

import control.client.ClientController;
import model.Method;
import model.Request;

public class ClientMain {
    public static void main(String[] args) { 
        ClientController client = new ClientController();
        String clientID = client.getClientID();
        
        client.sendRequest(new Request(Method.GET, clientID));
        client.sendRequest(new Request(Method.POST, clientID));
        client.sendRequest(new Request(Method.PUT, clientID));
        client.sendRequest(new Request(Method.PATCH, clientID));
        client.sendRequest(new Request(Method.DELETE, clientID));
        client.sendRequest(new Request(Method.OPTIONS, clientID));
        client.sendRequest(new Request(Method.END, clientID));
    }
}
