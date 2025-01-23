package com.inn.cashflow.server.core.common.Constants;

public final class CommonConstants {
    
    private CommonConstants() {}

    // Date and time formats
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss";

    // Response messages
    public static final String SUCCESS_MESSAGE = "Operation completed successfully";
    public static final String FAILURE_MESSAGE = "Operation failed";
    public static final String NOT_FOUND_MESSAGE = "Requested resource not found";

    // Error codes (if not using enums)
    public static final String ERROR_CODE_GENERIC = "999";
    public static final String ERROR_CODE_NOT_FOUND = "404";
    public static final String ERROR_CODE_UNAUTHORIZED = "401";

    public static final class Roles {
        public static final String ADMIN = "ADMIN";
        public static final String USER = "USER";
    }

    // Nested classes for grouping related constants
    public static final class ApiEndpoints {
        public static final String USERS = "/api/users";
        public static final String EXPENSES = "/api/expenses";
        public static final String INCOME_SOURCES = "/api/income-sources";
    }

    public static final class Status {
        public static final String ACTIVE = "ACTIVE";
        public static final String INACTIVE = "INACTIVE";
        public static final String DELETED = "DELETED";
    }
 
}
