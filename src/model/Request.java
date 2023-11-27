package model;

import java.io.Serializable;

public class Request implements Serializable {
    private Method method;
    
    public Request(Method method) {
        this.method = method;
    }

    public Method getMethod() {
        return method;
    }
}
