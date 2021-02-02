package org.fundacionjala.app.quizz.model.validator;

import java.util.List;

public class OnlyUppercaseValidator implements Validator{

    private static final String ERROR_MESSAGE = "Must be only uppercase characters";

    @Override
    public void validate(String value, String conditionValue, List<String> errors) {
        try {
            for (int i = 0; i < value.length(); i++){
                if (!Character.isUpperCase(value.charAt(i))){
                    errors.add(ERROR_MESSAGE);
                    break;
                }
            }
        } catch (NumberFormatException exception) {
            exception.printStackTrace();
            errors.add(IntegerParser.ERROR_MESSAGE_INVALID_NUMBER);
        }
    }
}
