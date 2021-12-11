package by.bsuir.Mukhliada.util.View;

import by.bsuir.Mukhliada.util.BaseClasses.Books.Book;

import java.util.List;

public class View {
    private static final int PAGESIZE = 3;

    public static int displayPage(List list, int pageNum) {
        for (int i = pageNum * PAGESIZE; i < pageNum * PAGESIZE + PAGESIZE; i++) {
            if (i < list.size() && i >= 0) {
                System.out.println(list.get(i).toString());
            }
        }
        return pageNum + 1;
    }

    public static void displayFullCatalog(List list) {
        for (Object book : list) {
            System.out.println(book.toString());
        }
    }

    public static void displayDescription(Book book) {
        char[] description =  book.getDescription().toCharArray();
        final int stringBreak = 50;
        boolean breaker = false;

        for (int i = 0; i < description.length; i++) {
            if (i % stringBreak == 0 && i != 0) {
                breaker = true;
            }

            if (description[i] == ' ' && breaker) {
                breaker = false;
                description[i] = '\n';
            }
        }

        System.out.println(description);
    }

    public static int getPAGESIZE() {
        return PAGESIZE;
    }
}