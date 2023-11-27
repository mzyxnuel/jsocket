package main;

import control.client.ClientController;
import model.Method;
import model.Request;

public class ClientMain {
    public static void main(String[] args) { 
        ClientController client = new ClientController();
        
        client.sendRequest(new Request(Method.GET));
        client.sendRequest(new Request(Method.POST));
        client.sendRequest(new Request(Method.PUT));
        client.sendRequest(new Request(Method.PATCH));
        client.sendRequest(new Request(Method.DELETE));
        client.sendRequest(new Request(Method.OPTIONS));
        client.sendRequest(new Request(Method.END));
    }
}
