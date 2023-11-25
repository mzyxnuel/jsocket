package model;

import java.io.Serializable;

public class Request implements Serializable {
    private Method method;
    private String clientID;
    
    public Request(Method method, String clientID) {
        this.method = method;
        this.clientID = clientID;
    }

    public Method getMethod() {
        return method;
    }

    public String getClientID() {
        return clientID;
    }
}
