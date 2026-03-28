package org.example;

class UserInputAdapter {
    private Validator chain;
    private final Validator nameValidator;
    private final Validator emailValidator;
    private final Validator facultyValidator;
    public UserInputAdapter() {
        this.nameValidator = new EmptyValidator();

        this.emailValidator = new EmptyValidator();
        this.emailValidator.setChainNext(new EmailValidator());

        this.facultyValidator = new EmptyValidator();
        this.facultyValidator.setChainNext(new FacultyValidator());
    }

        public Student adaptInputToStudent(String name, String email, String faculty) {

            boolean isNameValid = nameValidator.validateChainStep(name);
            boolean isEmailValid = emailValidator.validateChainStep(email);
            boolean isFacultyValid = facultyValidator.validateChainStep(faculty);

            if (isNameValid && isEmailValid && isFacultyValid) {
                return new Student.StudentBuilder()
                        .buildName(name)
                        .buildEmail(email)
                        .buildFaculty(faculty)
                        .getResult();
            }
            return null;
        }
}