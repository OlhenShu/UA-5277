package com.softserve.academy.module11;

/**
 * The BookDemo class is a demonstration class for the Book record and BookManager class.
 * It can be used to create instances of Book and display their information.
 */
public class BookDemo {
    public static void main(String[] args) {
        BookManager bookManager = new BookManager();
        bookManager.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925));
        bookManager.addBook(new Book("To Kill a Mockingbird", "Harper Lee", 1960));
        bookManager.addBook(new Book("1984", "George Orwell", 1949));
        bookManager.addBook(new Book("Pride and Prejudice", "Jane Austen", 1813));
        bookManager.addBook(new Book("The Catcher in the Rye", "J.D. Salinger", 1951));
        bookManager.addBook(new Book("The Hobbit", "J.R.R. Tolkien", 1937));
        bookManager.addBook(new Book("Fahrenheit 451", "Ray Bradbury", 1953));
        bookManager.addBook(new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954));
        bookManager.addBook(new Book("Animal Farm", "George Orwell", 1945));
        bookManager.addBook(new Book("Brave New World", "Aldous Huxley", 1932));
        bookManager.addBook(new Book("Moby-Dick", "Herman Melville", 1851));

        System.out.println("All books:");
        bookManager.getAllBooks().forEach(System.out::println);

        bookManager.removeBook(new Book("1984", "George Orwell", 1949));
        System.out.println("\nAfter removing '1984':");
        bookManager.getAllBooks().forEach(System.out::println);
        System.out.println(bookManager.findByTitle("The Hobbit"));
    }

}
