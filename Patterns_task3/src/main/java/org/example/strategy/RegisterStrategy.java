package org.example.strategy;

import org.example.builder.Student;
import org.example.chain.EmptyValidator;
import org.example.chain.EmailValidator;
import org.example.chain.NameValidator;
import org.example.chain.Validator;
import java.util.Map;
import java.util.Scanner;

public class RegisterStrategy implements UserChoiceStrategy {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void invoke(String name, Map<String, Student> db) {
        System.out.print("Enter name for registration: ");
        String inputName = scanner.nextLine();

        Validator nameValidator = new EmptyValidator(new NameValidator(null));
        if (!nameValidator.validate(inputName)) {
            return;
        }

        if (db.containsKey(inputName)) {
            System.out.println("Error: Student already exists!");
            return;
        }

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        Validator emailValidator = new EmptyValidator(new EmailValidator(null));
        if (!emailValidator.validate(email)) {
            return;
        }

        Student newStudent = Student.builder()
                .name(inputName)
                .email(email)
                .isHeadman(false)
                .build();

        db.put(inputName, newStudent);
        System.out.println("[Success]: Student registered!");
    }
}
