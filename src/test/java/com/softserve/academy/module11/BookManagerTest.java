package com.softserve.academy.module11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookManagerTest {

    private BookManager bookManager;
    private Book book1;
    private Book book2;
    private Book book3;

    @BeforeEach
    void setUp() {
        bookManager = new BookManager();
        book1 = new Book("Kobzar", "Taras Shevchenko", 1840);
        book2 = new Book("Shadows of Forgotten Ancestors", "Mykhailo Kotsiubynsky", 1911);
        book3 = new Book("Forest Song", "Lesya Ukrainka", 1911);
    }

    @Nested
    @DisplayName("Create (Add)")
    class CreateTests {
        @Test
        void testAddBookSuccess() {
            Book added = bookManager.addBook(book1);
            assertEquals(book1, added);
            assertEquals(1, bookManager.size());
            assertFalse(bookManager.isEmpty());
            assertTrue(bookManager.contains(book1));
        }

        @Test
        void testAddInvalidBookThrowsException() {
            assertThrows(IllegalArgumentException.class, () -> bookManager.addBook(null));
            assertThrows(IllegalArgumentException.class, () -> bookManager.addBook(new Book(null, "Author", 2020)));
            assertThrows(IllegalArgumentException.class, () -> bookManager.addBook(new Book("Title", null, 2020)));
            assertThrows(IllegalArgumentException.class, () -> bookManager.addBook(new Book("Title", "Author", 0)));
            assertThrows(IllegalArgumentException.class, () -> bookManager.addBook(new Book("Title", "Author", -1)));
            assertThrows(IllegalArgumentException.class, () -> bookManager.addBook(new Book("  ", "Author", 2020)));
            assertThrows(IllegalArgumentException.class, () -> bookManager.addBook(new Book("Title", "  ", 2020)));
        }

        @Test
        void testAddMultipleBooks() {
            bookManager.addBooks(List.of(book1, book2, book3));
            assertEquals(3, bookManager.size());
        }
    }

    @Nested
    @DisplayName("Read (Retrieve and Search)")
    class ReadTests {
        @BeforeEach
        void initBooks() {
            bookManager.addBooks(List.of(book1, book2, book3));
        }

        @Test
        void testGetAllBooks() {
            List<Book> books = bookManager.getAllBooks();
            assertEquals(3, books.size());
            assertEquals(book1, books.get(0));
            assertThrows(UnsupportedOperationException.class, () -> books.add(new Book("New", "Author", 2024)));
        }

        @Test
        void testGetBookByIndex() {
            assertEquals(book1, bookManager.getBookByIndex(0));
            assertEquals(book2, bookManager.getBookByIndex(1));
            assertThrows(IndexOutOfBoundsException.class, () -> bookManager.getBookByIndex(-1));
            assertThrows(IndexOutOfBoundsException.class, () -> bookManager.getBookByIndex(3));
        }

        @Test
        void testFindByTitle() {
            Book found = bookManager.findByTitle("kobzar");
            assertNotNull(found);
            assertEquals(book1, found);

            Book notFound = bookManager.findByTitle("Unknown");
            assertNull(notFound);

            assertNull(bookManager.findByTitle(null));
        }

        @Test
        void testFindByAuthor() {
            List<Book> shevchenkoBooks = bookManager.findByAuthor("Taras Shevchenko");
            assertEquals(1, shevchenkoBooks.size());
            assertEquals(book1, shevchenkoBooks.get(0));

            assertTrue(bookManager.findByAuthor("NonExistent").isEmpty());
            assertTrue(bookManager.findByAuthor(null).isEmpty());
        }

        @Test
        void testFindByYear() {
            List<Book> booksFrom1911 = bookManager.findByYear(1911);
            assertEquals(2, booksFrom1911.size());
            assertTrue(booksFrom1911.contains(book2));
            assertTrue(booksFrom1911.contains(book3));

            assertTrue(bookManager.findByYear(2000).isEmpty());
        }
    }

    @Nested
    @DisplayName("Update")
    class UpdateTests {
        @BeforeEach
        void initBooks() {
            bookManager.addBooks(List.of(book1, book2));
        }

        @Test
        void testUpdateBookByIndex() {
            Book updatedBook = new Book("Kobzar (Illustrated)", "Taras Shevchenko", 1860);
            Book oldBook = bookManager.updateBook(0, updatedBook);

            assertEquals(book1, oldBook);
            assertEquals(updatedBook, bookManager.getBookByIndex(0));
            assertEquals(2, bookManager.size());
        }

        @Test
        void testUpdateBookByObject() {
            Book updatedBook = new Book("Kobzar 2nd Edition", "Taras Shevchenko", 1860);
            boolean updated = bookManager.updateBook(book1, updatedBook);

            assertTrue(updated);
            assertEquals(updatedBook, bookManager.getBookByIndex(0));

            boolean notUpdated = bookManager.updateBook(book3, updatedBook);
            assertFalse(notUpdated);
        }

        @Test
        void testUpdateInvalidBookThrowsException() {
            assertThrows(IllegalArgumentException.class, () -> bookManager.updateBook(0, null));
            assertThrows(IndexOutOfBoundsException.class, () -> bookManager.updateBook(5, book3));
        }
    }

    @Nested
    @DisplayName("Delete (Remove)")
    class DeleteTests {
        @BeforeEach
        void initBooks() {
            bookManager.addBooks(List.of(book1, book2, book3));
        }

        @Test
        void testRemoveBook() {
            assertTrue(bookManager.removeBook(book2));
            assertEquals(2, bookManager.size());
            assertFalse(bookManager.contains(book2));

            assertFalse(bookManager.removeBook(new Book("Unknown", "Author", 2000)));
        }

        @Test
        void testRemoveBookByIndex() {
            Book removed = bookManager.removeBookByIndex(1);
            assertEquals(book2, removed);
            assertEquals(2, bookManager.size());
            assertEquals(book3, bookManager.getBookByIndex(1));
            assertThrows(IndexOutOfBoundsException.class, () -> bookManager.removeBookByIndex(10));
        }

        @Test
        void testRemoveByTitle() {
            assertTrue(bookManager.removeByTitle("kobzar"));
            assertEquals(2, bookManager.size());
            assertFalse(bookManager.contains(book1));

            assertFalse(bookManager.removeByTitle("Unknown"));
            assertFalse(bookManager.removeByTitle(null));
        }

        @Test
        void testRemoveByAuthor() {
            assertTrue(bookManager.removeByAuthor("Lesya Ukrainka"));
            assertEquals(2, bookManager.size());
            assertFalse(bookManager.contains(book3));

            assertFalse(bookManager.removeByAuthor("Unknown"));
            assertFalse(bookManager.removeByAuthor(null));
        }

        @Test
        void testClear() {
            bookManager.clear();
            assertEquals(0, bookManager.size());
            assertTrue(bookManager.isEmpty());
        }
    }
}
