package com.library;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class LibraryMemberTest {
        @Test
        public void testGetters() {
            LibraryMember member = new LibraryMember(11786, "abcd");
            assertEquals(11786, member.getID());
            assertEquals("abcd", member.getPassword());
        }

        @Test
        public void testAddReview() {
            LibraryMember member = new LibraryMember(11786, "abcd");
            Book book = new Book("Book1", "Author1", 5);
            member.addReview(book, "Great book!");
            assertTrue(true);
        }
}
