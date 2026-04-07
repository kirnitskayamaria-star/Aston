package org.example.chain;

public class EmailValidator implements Validator {
    private final Validator next;

    public EmailValidator(Validator next) {
        this.next = next;
    }

    @Override
    public boolean validate(String email) {
        if (email == null || !email.contains("@")) {
            System.out.println("Incorrect email!");
            return false;
        }
        return next == null || next.validate(email);
    }
}
