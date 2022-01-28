package util;

import java.util.Objects;

public class ValidateInput {

    private String yourInput;

    public String getYourInput() {
        return yourInput;
    }

    public ValidateInput(String input) {
        this.yourInput = isEmptyOrNull(input);
    }

    private String isEmptyOrNull(String input) {
        if (Objects.isNull(input) || "".equals(input)) {
            input = "0";
        }
        return input;
    }


}
