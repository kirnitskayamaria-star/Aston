package org.example;

import java.util.Objects;

public record Book(String title, int pages, int year) {


    public static int compareByPages(final Book b1, final Book b2) {
        return Integer.compare(b1.pages, b2.pages);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Book book = (Book) o;
        return pages == book.pages && year == book.year && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, pages, year);
    }

    @Override
    public String toString() {
        return String.format("'%s' (%d pages, %d year)", title, pages, year);
    }
}
