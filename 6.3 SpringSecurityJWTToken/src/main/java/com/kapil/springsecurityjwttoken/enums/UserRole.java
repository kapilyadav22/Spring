package com.kapil.springsecurityjwttoken.enums;

public enum UserRole {
    ADMIN("ROLE_ADMIN"),
    STUDENT("ROLE_STUDENT"),
    USER("ROLE_USER");

    private final String roleName;

    UserRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}
