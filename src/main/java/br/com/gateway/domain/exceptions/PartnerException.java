package br.com.gateway.domain.exceptions;


import jakarta.ws.rs.core.Response;

public class PartnerException extends DefaultException {

    public PartnerException() {
        super("communication-problem-with-the-partner-bank");
    }

    @Override
    public Response.Status getHttpStatus() {
        return Response.Status.PRECONDITION_FAILED;
    }
}
