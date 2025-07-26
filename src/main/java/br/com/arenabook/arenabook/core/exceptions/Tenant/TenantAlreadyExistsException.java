package br.com.arenabook.arenabook.core.exceptions.Tenant;

public class TenantAlreadyExistsException extends RuntimeException {
    public TenantAlreadyExistsException(String message) {
        super(message);
    }
}