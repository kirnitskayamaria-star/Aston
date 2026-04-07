package org.example;

import org.example.builder.Student;
import org.example.strategy.*;
import java.util.*;

public class StudentManager {
    private final Map<UserChoice, UserChoiceStrategy> choiceToStrategy = new HashMap<>();
    private final Map<String, Student> db = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);

    public StudentManager() {
        choiceToStrategy.put(UserChoice.DELETE, new DeleteStrategy());
        choiceToStrategy.put(UserChoice.INFO, new InfoStrategy());
        choiceToStrategy.put(UserChoice.HEADMAN, new HeadmanStrategy());
        choiceToStrategy.put(UserChoice.REGISTER, new RegisterStrategy());
        choiceToStrategy.put(UserChoice.EXIT, (name, db) -> System.exit(0));
    }

    public void startApp() {
        while (true) {
            System.out.println("\n1-Delete, 2-Info, 3-Headman, 4-Exit, 5-Register");
            System.out.print("Enter command: ");
            String input = scanner.nextLine();

            final var userChoice = UserChoice.fromValue(input);
            final var choiceStrategy = choiceToStrategy.get(userChoice);
            choiceStrategy.invoke("", db);
        }
    }

}
