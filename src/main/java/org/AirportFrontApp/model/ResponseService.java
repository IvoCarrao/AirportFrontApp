package org.AirportFrontApp.model;

import org.springframework.stereotype.Component;

@Component

public class ResponseService {
    private Object requestedObject;
    private boolean operationSuccess;
    private String message;

    public Object getRequestedObject() {
        return requestedObject;
    }

    public void setRequestedObject(Airplane requestedObject) {
        this.requestedObject = requestedObject;
    }

    public boolean isOperationSuccess() {
        return operationSuccess;
    }

    public void setOperationSuccess(boolean operationSuccess) {
        this.operationSuccess = operationSuccess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
