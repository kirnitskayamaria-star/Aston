package org.example;

abstract class Validator {
    protected Validator next;
    public void setChainNext(Validator next) { this.next = next; }
    public abstract boolean validateChainStep(String data);
}

class EmptyValidator extends Validator {
    public boolean validateChainStep(String data) {
        if (data == null || data.trim().isEmpty()) {
            System.out.println("Error - empty data!");
            return false;
        }
        return next == null || next.validateChainStep(data);
    }
}

class EmailValidator extends Validator {
    public boolean validateChainStep(String data) {
        if (!data.contains("@")) {
            System.out.println("Error - invalid Email!");
            return false;
        }
        return next == null || next.validateChainStep(data);
    }

}
class FacultyValidator extends Validator {
    public boolean validateChainStep(String data) {
        if(!data.equalsIgnoreCase("Law") && !data.equalsIgnoreCase("IT") && !data.equalsIgnoreCase("Engineering")) {
            System.out.println("Error - invalid Faculty!");
            return false;
        }
        return next == null || next.validateChainStep(data);
    }
}
