package no.task.registrationform.exception;

import org.springframework.http.HttpStatusCode;

public class BringsException extends RuntimeException {

    private final HttpStatusCode statusCode;

    public BringsException(HttpStatusCode statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }

    public HttpStatusCode getStatusCode() {
        return statusCode;
    }
}
