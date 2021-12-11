import task12.Book;

import java.util.Comparator;

public class ComparatorAuthorName implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        int result = o1.getAuthor().compareTo(o2.getAuthor());
        if (result == 0) {
            return o1.getTitle().compareTo(o2.getTitle());
        }
        return result;
    }
}
