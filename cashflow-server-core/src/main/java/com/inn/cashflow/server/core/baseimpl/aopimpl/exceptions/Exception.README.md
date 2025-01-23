To make the `CashFlowSystemException` class easier to use and integrate with the suggested `ErrorCode` enum, we can refactor it to accept `ErrorCode` directly while maintaining compatibility with the current constructor for flexibility.

Here’s the updated implementation:

---

### **Refactored CashFlowSystemException Class**
```java
package com.inn.cashflow.server.core.baseimpl.aopimpl.exceptions;

import com.inn.cashflow.server.core.common.errors.ErrorCode;

public class CashFlowSystemException extends RuntimeException {
    
    private final String errorCode;

    // Constructor using ErrorCode enum
    public CashFlowSystemException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode.getCode();
    }

    // Constructor using ErrorCode enum with a custom message
    public CashFlowSystemException(ErrorCode errorCode, String customMessage) {
        super(customMessage);
        this.errorCode = errorCode.getCode();
    }

    // Constructor using direct message and error code
    public CashFlowSystemException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
```

---

### **Usage Scenarios**

#### **Using the ErrorCode Enum**
1. **Default Error Message**:
   ```java
   throw new CashFlowSystemException(ErrorCode.INCOME_SOURCE_ALREADY_EXISTS);
   ```

2. **Custom Error Message**:
   ```java
   throw new CashFlowSystemException(ErrorCode.INCOME_SOURCE_ALREADY_EXISTS, "The source name is already in use. Please update or choose another name.");
   ```

#### **Using Custom Message and Error Code (Backwards Compatible)**
For scenarios where the `ErrorCode` enum is not applicable:
```java
throw new CashFlowSystemException("Custom error message", "999");
```

---

### **Updated ErrorCode Enum (Optional)**
Here’s the previously suggested `ErrorCode` enum for reference:
```java
package com.inn.cashflow.server.core.common.errors;

public enum ErrorCode {
    USER_NOT_FOUND("001", "User not found"),
    INCOME_SOURCE_ALREADY_EXISTS("006", "Source name already exists, do you want to update the amount?"),
    OPERATION_FAILED("009", "Operation failed");

    private final String code;
    private final String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
```

---

### **Benefits of This Refactor**
1. **Enhanced Usability**: Using `ErrorCode` reduces boilerplate code and ensures consistency.
2. **Backward Compatibility**: Existing code using `message` and `errorCode` directly will still work.
3. **Flexibility**: Allows using either predefined error codes or custom error messages as needed.
4. **Scalability**: Easily add new error codes without changing the exception-handling logic.

Let me know if you need further refinements!