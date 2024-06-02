package com.library;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;

public class LibrarianTest {

    @BeforeEach
    public void setUp() {
        Librarian.books = new ArrayList<>();
    }

    @Test
    public void testDefaultBooks() {
        Book book1 = new Book("Book1", "Author1", 5);
        Book book2 = new Book("Book2", "Author2", 3);
        Book book3 = new Book("Book3", "Author3", 7);

        Librarian.books.add(book1);
        Librarian.books.add(book2);
        Librarian.books.add(book3);

        Librarian.defaultBooks();

        List<Book> books = Librarian.books;
        assertEquals(5, books.size(), "Expected number of books is 5");
    }

    @Test
    public void testAddBook() {
        Librarian.addBook("New Book", "New Author", 5);

        List<Book> books = Librarian.books;
        assertEquals(1, books.size(), "Expected number of books after addition is 1");
    }

}
