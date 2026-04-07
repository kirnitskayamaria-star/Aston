package org.example.strategy;

import org.example.builder.Student;
import org.example.decorator.HeadmanDecorator;
import org.example.proxy.InfoService;
import org.example.proxy.ProxyInfoService;

import java.util.Map;
import java.util.Scanner;

public class InfoStrategy implements UserChoiceStrategy {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void invoke(String name, Map<String, Student> db) {
        System.out.print("Enter student name to show info: ");
        String inputName = scanner.nextLine().trim();


        Student s = db.get(inputName);

        if (s == null) {
            System.out.println("Error: Student '" + inputName + "' not found!");
            return;
        }

        InfoService service = new ProxyInfoService();

        if (s.isHeadman()) {
            service = new HeadmanDecorator(service);
        }

        service.showInfo(s);
    }
}
