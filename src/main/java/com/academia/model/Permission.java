package com.academia.model;


public enum Permission {
    USER_READ("user:read"),
    USER_EDIT("user:edit"),
    USER_DELETE("user:delete"),
    USER_WRITE("user:write");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
