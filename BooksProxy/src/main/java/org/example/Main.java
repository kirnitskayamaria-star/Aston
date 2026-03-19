package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Храним наши прокси-объекты, чтобы они не "умирали" после одного цикла
        Map<String, StudentInterface> cache = new HashMap<>();

        System.out.println("=== Система поиска студентов (для выхода введите 'exit') ===");

        while (true) {
            System.out.print("\nВведите имя студента: ");
            String inputName = scanner.nextLine();

            if (inputName.equalsIgnoreCase("exit")) {
                System.out.println("Выход из программы...");
                break;
            }

            // Ищем, создавали ли мы прокси для этого имени раньше
            StudentInterface student = cache.get(inputName);

            if (student == null) {
                // Если не создавали — создаем новый Прокси и кладем в наш "реестр"
                student = new StudentProxy(inputName);
                cache.put(inputName, student);
            }

            System.out.println("--- Обращение к объекту ---");
            student.showInfo();
        }
    }
}
