package enums;

public enum ErrorMessages {
    PHONE_NUMBER_FIELD("We can't send a code to this phone number. Try using a different one."),

    ;

    private final String message;

    // Constructor to initialize the message for each enum constant
    ErrorMessages(String message) {
        this.message = message;
    }

    // Method to get the error message
    public String getMessage() {
        return message;
    }

    }
