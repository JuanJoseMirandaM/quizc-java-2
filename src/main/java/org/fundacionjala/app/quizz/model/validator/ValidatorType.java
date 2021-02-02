package org.fundacionjala.app.quizz.model.validator;

public enum ValidatorType {
    REQUIRED(1, "Required", new RequiredValidator()),
    DATE(2, "Date", new DateValidator()),
    MIN(3, "Min", new MinValidator()),
    MAX(4, "Max", new MaxValidator()),
    MIN_LENGTH(5, "Min Length", new MinLengthValidator()),
    MAX_LENGTH(6, "Max Length", new MaxLengthValidator()),
    ONLY_UPPERCASE(7, "Only Uppercase", new OnlyUppercaseValidator());

    private final int code;
    private final String displayName;
    private final Validator validator;

    ValidatorType(int code, String displayName, Validator validator) {
        this.code = code;
        this.displayName = displayName;
        this.validator = validator;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return displayName;
    }

    public Validator getValidator() {
        return validator;
    }

    public static ValidatorType getByCode(int option) {
        for (ValidatorType validator : ValidatorType.values()) {
            if (validator.getCode() == option) {
                return validator;
            }
        }

        return null;
    }
}
