package org.example;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        StudentLoader loader = new StudentLoader();
        BookService service = new BookService();

        List<Student> students = loader.loadFromResource("students.json");
        service.processStudents(students);
    }
}