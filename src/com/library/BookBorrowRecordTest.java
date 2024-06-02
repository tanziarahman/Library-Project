package com.library;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class BookBorrowRecordTest {
        @Test
        public void testGetters() {
            LocalDate date = LocalDate.of(2023, 6, 1);
            BookBorrowRecord record = new BookBorrowRecord(1, "Book1", date);
            assertEquals(1, record.getID());
            assertEquals("Book1", record.getTitle());
            assertEquals(date, record.getStartDate());
        }
}
