package org.example.strategy;

import org.example.builder.Student;
import java.util.Map;
import java.util.Scanner;

public class DeleteStrategy implements UserChoiceStrategy {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void invoke(String name, Map<String, Student> db) {
        System.out.print("Enter name to delete: ");
        String nameFromUser = scanner.nextLine().trim();

        if (db.containsKey(nameFromUser)) {
            db.remove(nameFromUser);
            System.out.println("The student '" + nameFromUser + "' is deleted.");
        } else {
            System.out.println("Error: Student '" + nameFromUser + "' not found.");
        }
    }
}
