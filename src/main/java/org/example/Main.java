package org.example;
import java.util.List;

public class Main {
    static void main() {

        ImmutableDepartment itDept = new ImmutableDepartment("IT", List.of("Иван", "Алексей", "Ольга"));
        ImmutableDepartment hrDept = new ImmutableDepartment("HR", List.of("Анна", "Михаил", "Мария"));

        itDept = itDept.addEmployee("Вячеслав");
        hrDept = hrDept.addEmployee("Екатерина");

        System.out.println(itDept);
        System.out.println(hrDept);
    }
}
