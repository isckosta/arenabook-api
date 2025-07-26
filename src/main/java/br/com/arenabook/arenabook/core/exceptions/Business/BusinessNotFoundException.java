package br.com.arenabook.arenabook.core.exceptions.Business;

public class BusinessNotFoundException extends RuntimeException {
    public BusinessNotFoundException(String message) {
        super(message);
    }
}
