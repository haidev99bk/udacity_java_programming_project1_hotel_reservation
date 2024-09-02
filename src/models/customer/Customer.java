package models.customer;

import java.util.regex.Pattern;

public class Customer {
    private String firstName;
    private String lastName;
    private String email;
    private final String REGEX_EMAIL_PATTERN = "^(.+)@(.+).(.+)$";

    public Customer(String firstName, String lastName, String email) {
        Pattern pattern = Pattern.compile (REGEX_EMAIL_PATTERN);

        if (!pattern.matcher (email).matches ()) {
            throw new IllegalArgumentException (email);
        } else {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        }
    }

    @Override
    public String toString() {
        return new String ("First Name: " + this.firstName + ", Last Name: " + this.lastName + ", Email: " + this.email);
    }


}
