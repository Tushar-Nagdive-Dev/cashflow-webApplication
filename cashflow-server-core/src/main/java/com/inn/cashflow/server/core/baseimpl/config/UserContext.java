package com.inn.cashflow.server.core.baseimpl.config;

import java.util.Set;

public class UserContext {
    
    private static final ThreadLocal<UserContext> userContext = new ThreadLocal<>();

    private Long id;

    private String username;

    private String firstName;

    private String lastName;

    private String email;

    private Set<String> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public static UserContext getCurrentUser() {
        return userContext.get();
    }

    public static void setCurrentUser(UserContext context) {
        userContext.set(context);
    }

    public static void clear() {
        userContext.remove();
    }
}
