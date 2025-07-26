package br.com.arenabook.arenabook.core.exceptions.Tenant;

public class TenantNotFoundException extends RuntimeException {
    public TenantNotFoundException(String message) {
        super(message);
    }
}
