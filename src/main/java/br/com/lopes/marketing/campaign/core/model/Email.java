package br.com.lopes.marketing.campaign.core.model;

import java.util.regex.Pattern;

public class Email {

    private static final String VALIDATION_MESSAGE = "invalid e-mail address";
    private static final String REGEX_PATTERN =  "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

    private String address;

    public Email(String address) {
        if (address == null || !isValid(address)) {
            throw new IllegalArgumentException(VALIDATION_MESSAGE);
        }
        this.address = address;
    }

    public static Email of(String address) {
        return new Email(address);
    }

    private boolean isValid(String address) {
        return Pattern.compile(REGEX_PATTERN).matcher(address)
                .matches();
    }

    @Override
    public String toString() {
        return this.address;
    }
}
