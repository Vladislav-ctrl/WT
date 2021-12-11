import task12.Book;

import java.util.Comparator;

public class ComparatorAuthorNamePrice implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        int resultAuthor = o1.getAuthor().compareTo(o2.getAuthor());
        if (resultAuthor == 0) {
            int resultName = o1.getTitle().compareTo(o2.getTitle());
            if (resultName == 0) {
                return o1.getPrice() - o2.getPrice();
            }
            return resultName;
        }
        return resultAuthor;
    }
}
