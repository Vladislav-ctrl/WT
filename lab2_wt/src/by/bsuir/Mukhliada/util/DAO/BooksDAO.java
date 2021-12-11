package by.bsuir.Mukhliada.util.DAO;

import by.bsuir.Mukhliada.util.BaseClasses.Books.Book;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BooksDAO extends DAO<Book> {
    private static final String BOOKSFILE = "BooksDB.json";
    private static HashMap<Integer, Book> books = new HashMap<>();

    @Override
    public void close() {
        saveDB(BOOKSFILE, books);
    }

    public BooksDAO() {
        books = loadDB(BOOKSFILE, new TypeToken<HashMap<Integer, Book>>(){}.getType());
        if (books.size() == 0){
            Book.setCount(0);
        } else {
            Book.setCount(books.get(books.size() - 1).getBookID() + 1);
        }
    }

    @Override
    public List<Book> getAll() {
        return new ArrayList<Book>(books.values());
    }

    @Override
    public Book getEntityById(Integer id) {
        return books.get(id);
    }

    @Override
    public Book update(Book entity) {
        return books.replace(entity.getBookID(), entity);
    }

    @Override
    public boolean delete(Integer id) {
        if (books.remove(id) != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean create(Book entity) {
        books.put(entity.getBookID(), entity);

        if (entity.equals(getEntityById(entity.getBookID()))){
            return true;
        }

        return false;
    }
}
