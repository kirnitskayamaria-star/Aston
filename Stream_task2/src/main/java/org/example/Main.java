package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        InputStream stream = Main.class.getClassLoader().getResourceAsStream("students.json");

        List<Student> students = mapper.readValue(stream, new TypeReference<List<Student>>() {});


        System.out.println(
                students.stream()
                        .peek(s -> System.out.println(s.toString()))
                        .map(s -> s.books)
                        .flatMap(List::stream)
                        .distinct()
                        .sorted(Student.Book::compareByPages)
                        .filter(b -> b.year > 2000)
                        .limit(3)
                        .map(b -> b.year)
                        .findFirst()
                        .map(year -> "The year of the found book " + year)
                        .orElse("The book is not found")
        );

    }
}