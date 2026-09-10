package com.softserve.academy.module11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * The BookManager class is responsible for managing a collection of books.
 * It provides methods to create, read, update, and delete books from the collection (CRUD operations).
 */
public class BookManager {

    private final List<Book> books;

    /**
     * Constructs a new empty BookManager.
     */
    public BookManager() {
        this.books = new ArrayList<>();
    }

    /**
     * Constructs a BookManager with initial list of books.
     *
     * @param initialBooks Initial collection of books.
     */
    public BookManager(List<Book> initialBooks) {
        this.books = new ArrayList<>();
        if (initialBooks != null) {
            for (Book book : initialBooks) {
                addBook(book);
            }
        }
    }

    // ==========================================
    // 1. CREATE (Додавання книг)
    // ==========================================

    /**
     * Adds a book to the collection.
     *
     * @param book The book to be added.
     * @return The added book.
     * @throws IllegalArgumentException if book is null or contains invalid fields.
     */
    public Book addBook(Book book) {
        validateBook(book);
        books.add(book);
        return book;
    }

    /**
     * Adds multiple books to the collection.
     *
     * @param booksToAdd List of books to add.
     */
    public void addBooks(List<Book> booksToAdd) {
        if (booksToAdd == null) {
            throw new IllegalArgumentException("Books list cannot be null");
        }
        for (Book book : booksToAdd) {
            addBook(book);
        }
    }

    // ==========================================
    // 2. READ (Отримання та пошук книг)
    // ==========================================

    /**
     * Returns an unmodifiable view of all books in the collection.
     *
     * @return List of all books.
     */
    public List<Book> getAllBooks() {
        return Collections.unmodifiableList(new ArrayList<>(books));
    }

    /**
     * Retrieves a book by its index in the collection.
     *
     * @param index The zero-based index.
     * @return The book at the specified index.
     * @throws IndexOutOfBoundsException if index is out of range.
     */
    public Book getBookByIndex(int index) {
        validateIndex(index);
        return books.get(index);
    }

    /**
     * Finds the first book matching the given title (case-insensitive).
     *
     * @param title The title to search for.
     * @return Book if found, or null otherwise.
     */
    public Book findByTitle(String title) {
        if (title == null || title.isBlank()) {
            return null;
        }
        for (Book book : books) {
            if (book.title().equalsIgnoreCase(title.trim())) {
                return book;
            }
        }
        return null;
    }

    /**
     * Finds all books by a specific author (case-insensitive).
     *
     * @param author The author name to search for.
     * @return List of books matching the author.
     */
    public List<Book> findByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        if (author == null || author.isBlank()) {
            return result;
        }
        for (Book book : books) {
            if (book.author().equalsIgnoreCase(author.trim())) {
                result.add(book);
            }
        }
        return result;
    }

    /**
     * Finds all books published in a specific year.
     *
     * @param year The publication year.
     * @return List of books published in that year.
     */
    public List<Book> findByYear(int year) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.year() == year) {
                result.add(book);
            }
        }
        return result;
    }

    /**
     * Checks if the collection contains the specified book.
     *
     * @param book The book to check.
     * @return true if the book exists in the collection, false otherwise.
     */
    public boolean contains(Book book) {
        return books.contains(book);
    }

    /**
     * Returns the total number of books in the collection.
     *
     * @return Number of books.
     */
    public int size() {
        return books.size();
    }

    /**
     * Checks if the collection is empty.
     *
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty() {
        return books.isEmpty();
    }

    // ==========================================
    // 3. UPDATE (Оновлення книг)
    // ==========================================

    /**
     * Updates the book at the specified index.
     *
     * @param index       The index of the book to update.
     * @param updatedBook The new book data.
     * @return The previous book that was replaced.
     * @throws IndexOutOfBoundsException if index is invalid.
     * @throws IllegalArgumentException  if updatedBook is invalid.
     */
    public Book updateBook(int index, Book updatedBook) {
        validateIndex(index);
        validateBook(updatedBook);
        return books.set(index, updatedBook);
    }

    /**
     * Replaces the first occurrence of oldBook with newBook.
     *
     * @param oldBook The book to replace.
     * @param newBook The new book.
     * @return true if replaced successfully, false if oldBook was not found.
     * @throws IllegalArgumentException if newBook is invalid.
     */
    public boolean updateBook(Book oldBook, Book newBook) {
        validateBook(newBook);
        int index = books.indexOf(oldBook);
        if (index != -1) {
            books.set(index, newBook);
            return true;
        }
        return false;
    }

    // ==========================================
    // 4. DELETE (Видалення книг)
    // ==========================================

    /**
     * Removes a specific book from the collection.
     *
     * @param book The book to remove.
     * @return true if removed, false if not found.
     */
    public boolean removeBook(Book book) {
        return books.remove(book);
    }

    /**
     * Removes the book at the specified index.
     *
     * @param index The index of the book to remove.
     * @return The removed book.
     * @throws IndexOutOfBoundsException if index is invalid.
     */
    public Book removeBookByIndex(int index) {
        validateIndex(index);
        return books.remove(index);
    }

    /**
     * Removes all books matching the given title (case-insensitive).
     *
     * @param title The title of books to remove.
     * @return true if at least one book was removed, false otherwise.
     */
    public boolean removeByTitle(String title) {
        if (title == null || title.isBlank()) {
            return false;
        }
        boolean removed = false;
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.title().equalsIgnoreCase(title.trim())) {
                iterator.remove();
                removed = true;
            }
        }
        return removed;
    }

    /**
     * Removes all books by the specified author (case-insensitive).
     *
     * @param author The author of books to remove.
     * @return true if at least one book was removed, false otherwise.
     */
    public boolean removeByAuthor(String author) {
        if (author == null || author.isBlank()) {
            return false;
        }
        boolean removed = false;
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.author().equalsIgnoreCase(author.trim())) {
                iterator.remove();
                removed = true;
            }
        }
        return removed;
    }

    /**
     * Clears all books from the collection.
     */
    public void clear() {
        books.clear();
    }

    // ==========================================
    // Helper validation methods
    // ==========================================

    private void validateBook(Book book) {
        if (book == null || book.title() == null || book.title().isBlank()
                || book.author() == null || book.author().isBlank()
                || book.year() <= 0) {
            throw new IllegalArgumentException("Book must have valid title, author, and positive year");
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= books.size()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for size " + books.size());
        }
    }
}
