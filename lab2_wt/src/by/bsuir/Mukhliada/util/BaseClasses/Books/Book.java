package by.bsuir.Mukhliada.util.BaseClasses.Books;

import java.io.Serializable;
import java.util.Objects;

public class Book implements Serializable {
    private BookType bookType = BookType.Paper;
    private String title = "";
    private String author = "";
    private String description = "";
    private static int count = 0;
    private int bookID = 0;

    public Book(BookType bookType, String title, String author, String description) {
        this.bookType = bookType;
        this.title = title;
        this.author = author;
        this.description = description;
        bookID = count++;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Book(int ... arg) { }

    public BookType getBookType() {
        return bookType;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public int getBookID() {
        return bookID;
    }

    public static void setCount(int DBCount) { count = DBCount; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookType == book.bookType &&
                title.equals(book.title) &&
                author.equals(book.author) &&
                description.equals(book.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookType, title, author, description);
    }

    @Override
    public String toString() {
        return "ID: " + bookID + "; title: " + title + "; author: " + author;
    }
}
