package br.com.gateway.domain.exceptions;

import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ExceptionHandler implements ExceptionMapper<DefaultException> {

    @Context
    private UriInfo uriInfo;

    @Override
    public Response toResponse(DefaultException exception) {
        return Response.status(exception.getHttpStatus())
                .entity(new ErrorMessage(exception.getMessage(), uriInfo.getPath()))
                .build();
    }

}