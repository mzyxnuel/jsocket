package model;

import java.io.Serializable;

public class Response implements Serializable {
    private Method method;
    private String message;
    
    public Response(Method method, String message) {
        this.method = method;
        this.message = message;
    }

    public Response(Method method) {
        this.method = method;
    }

    public Method getMethod() {
        return method;
    }

    public String getMessage() {
        return message;
    }
    
}
