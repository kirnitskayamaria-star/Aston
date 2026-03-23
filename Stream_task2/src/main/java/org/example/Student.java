package org.example;
import java.util.List;
public record Student (String name, List<Book> books) {

    @Override
    public String toString() {
        return String.format("Student: %s | Books: %s", this.name, this.books);
    }
}
