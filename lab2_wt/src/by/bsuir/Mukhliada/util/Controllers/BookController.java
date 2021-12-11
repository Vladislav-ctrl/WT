package by.bsuir.Mukhliada.util.Controllers;

import by.bsuir.Mukhliada.util.BaseClasses.Books.Book;
import by.bsuir.Mukhliada.util.BaseClasses.Books.BookType;
import by.bsuir.Mukhliada.util.Commands.Commands;
import by.bsuir.Mukhliada.util.DAO.BooksDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookController {

    private BooksDAO booksDAO;

    public BookController() {
        booksDAO = new BooksDAO();
    }

    public List<Book> getAllBooks(){
        return booksDAO.getAll();
    }

    public boolean addBook(String title, String author, String description, BookType bookType) {
        Book book = new Book(bookType, title, author, description);

        return booksDAO.create(book);
    }

    public boolean deleteBook(int ID) {

        return booksDAO.delete(ID);
    }

    private boolean checkAction(String ActionName, Book entity) {
        if (entity == null) {
            System.out.println(ActionName + " failed");
            return false;
        }

        System.out.println(ActionName + " successful");

        return true;
    }

    public boolean changeTitle(int id, String title) {
        Book book = booksDAO.getEntityById(id);

        if (book == null){
            System.out.println("Error ID incorrect!");
            return false;
        }

        book.setTitle(title);
        Book update = booksDAO.update(book);

        return checkAction("Update", update);
    }

    public boolean changeAuthor(int id, String author) {
        Book book = booksDAO.getEntityById(id);

        if (book == null){
            System.out.println("Error ID incorrect!");
            return false;
        }

        book.setAuthor(author);
        Book update = booksDAO.update(book);

        return checkAction("Update", update);
    }

    public boolean changeDescription(int id, String desc) {
        Book book = booksDAO.getEntityById(id);

        if (book == null){
            System.out.println("Error ID incorrect!");
            return false;
        }

        book.setDescription(desc);
        Book update = booksDAO.update(book);

        return checkAction("Update", update);
    }

    public boolean changeBookType(int id, BookType type) {
        Book book = booksDAO.getEntityById(id);

        if (book == null){
            System.out.println("Error ID incorrect!");
            return false;
        }

        book.setBookType(type);
        Book update = booksDAO.update(book);

        return checkAction("Update", update);
    }

    public List<Book> search(Commands type, String request) {

        List<Book> result = new ArrayList<Book>();
        List<Book> searchIn = booksDAO.getAll();

        switch (type) {
            case SearchTitle:
                result = searchIn.stream().filter(p -> p.getTitle().equals(request)).collect(Collectors.toList());
                break;
            case SearchAuthor:
                result = searchIn.stream().filter(p -> p.getAuthor().equals(request)).collect(Collectors.toList());
                break;
            default:
                System.out.println("No such place to search in!");
                return result;
        }

        return result;
    }

    public Book getBookById(int ID) {
        return booksDAO.getEntityById(ID);
    }

    public void save(){
        booksDAO.close();
    }
}
