package org.example;

import java.util.List;

public class BookService {
    public void processStudents(final List<Student> students) {
        students.stream()
                .peek(System.out::println)
                .flatMap(student -> student.books().stream())
                .distinct()
                .sorted(Book::compareByPages)
                .filter(book -> book.year() > 2000)
                .limit(3)
                .map(book -> book.year())
                .findFirst()
                .ifPresentOrElse(
                        year -> System.out.println("The year of the found book " + year),
                        () -> System.out.println("The book is not found")
                );
    }

}
