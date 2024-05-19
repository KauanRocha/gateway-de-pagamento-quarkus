package br.com.gateway.presentation.handlers;

public class ErrorMessage {

    private String message;
    private String path;


    public ErrorMessage(String path, String message) {
        this.path = path;
        this.message = message;
    }

    public ErrorMessage() {
        super();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}