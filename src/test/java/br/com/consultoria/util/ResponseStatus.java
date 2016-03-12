package br.com.consultoria.util;

import javax.ws.rs.core.Response.Status;

public class ResponseStatus {

    public static final int OK = Status.OK.getStatusCode();
    public static final int CREATED = Status.CREATED.getStatusCode();
    public static final int NO_CONTENT = Status.NO_CONTENT.getStatusCode();
    public static final int NOT_FOUND = Status.NOT_FOUND.getStatusCode();

}
