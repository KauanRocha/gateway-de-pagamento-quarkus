package br.com.gateway.domain.exceptions;

import jakarta.ws.rs.core.Response;

public class DefaultException extends RuntimeException {

    public DefaultException() {
        super("problem-to-process-payment");
    }
    public DefaultException(String message) {
        super(message);
    }

    public Response.Status getHttpStatus() {
        return Response.Status.INTERNAL_SERVER_ERROR;
    }
}
