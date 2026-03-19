package org.example;

import java.util.List;
import java.util.Objects;

public class Student {
    public String name;
    public List<Book> books;
    public Student() {}

    @Override
    public String toString() {
        return "Student: " + name + " | Books: " + books;
    }

    public static class Book {
        public String title;
        public int pages;
        public int year;

        public Book() {}

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Book book = (Book) o;
            return pages == book.pages && year == book.year && Objects.equals(title, book.title);
        }

        @Override
        public int hashCode() {
            return Objects.hash(title, pages, year);
        }

        public static int compareByPages(Book b1, Book b2) {
            return Integer.compare(b1.pages, b2.pages);
        }

        @Override
        public String toString() {
            return String.format("'%s' (%d pages, %d )", title, pages, year);
        }
    }

}