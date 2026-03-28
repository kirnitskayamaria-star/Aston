package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentManager {
    public void startApp() {
        Map<String, Student> db = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        UserInputAdapter adapter = new UserInputAdapter();

        while (true) {
            System.out.println("\n--- Main Page (students: " + db.size() + ") ---");
            System.out.print("Enter the name of the student (or 'exit'): ");
            String name = scanner.nextLine().trim();
            if (name.equalsIgnoreCase("exit")) break;

            if (db.containsKey(name)){
                System.out.println("Student is found. 1 - Delete, 2 - Info, 3 - Make a headman");
                String choice = scanner.nextLine();

                if (choice.equals("1")) {
                    new DeleteStrategy().executeStrategy(name, db);
                } else if (choice.equals("2")) {
                    Student s = db.get(name);
                    InfoService service = s.isHeadman() ? new HeadmanDecorator(new ProxyInfoService()) : new ProxyInfoService();
                    service.showInfo(s);
                } else if (choice.equals("3")) {
                    Student s = db.get(name);
                    if (s.isHeadman()) {
                        System.out.println("[Error]: " + name + " is already a headman!");
                    } else {
                        s.setHeadman(true);
                        System.out.println(s.getName() + " is a headman");
                    }
                }
            } else {
                System.out.println("Registration process");
                Student newS = null;

                while (newS == null) {
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter faculty: ");
                    String faculty = scanner.nextLine();

                    newS = adapter.adaptInputToStudent(name, email,  faculty);

                    if (newS == null) {
                        System.out.println("Try entering the data again");
                        System.out.println("Do you want to cancel the registration? (y/n)");
                        if(scanner.nextLine().equalsIgnoreCase("y")) break;
                    }
                }

                if (newS != null) {
                    db.put(name, newS);
                    System.out.println("[Success]: The student is saved!");
                }
            }
                }

    }
}