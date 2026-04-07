package org.example.strategy;

import org.example.builder.Student;

import java.util.Map;
import java.util.Scanner;

public class HeadmanStrategy implements UserChoiceStrategy {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void invoke(String name, Map<String, Student> db) {

        System.out.print("Enter student name to make a headman: ");
        String inputName = scanner.nextLine();

        Student s = db.get(inputName);

        if (s == null) {
            System.out.println("Error: Student '" + inputName + "' not found!");
            return;
        }

        if (s.isHeadman()) {
            System.out.println(inputName + " is already a headman!");
        } else {
            s.setHeadman(true);
            System.out.println(inputName + " is now a headman.");
        }
    }
}
