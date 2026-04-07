package org.example.chain;


public class EmptyValidator implements Validator {
    private final Validator next;

    public EmptyValidator(Validator next) {
        this.next = next;
    }


    @Override
    public boolean validate(String data) {
        if (data == null || data.trim().isEmpty()) {
            System.out.println("Error - empty data!");
            return false;
        }
        return next == null || next.validate(data);
    }
}