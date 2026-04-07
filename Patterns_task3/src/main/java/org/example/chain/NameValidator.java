package org.example.chain;

public class NameValidator implements Validator {
    private final Validator next;

    public NameValidator(Validator next) {
        this.next = next;
    }

    @Override
    public boolean validate(String name) {
        if (name == null || name.isBlank()) {
            System.out.println("The name cannot be blank");
            return false;
        }
        return next == null || next.validate(name);
    }
}
