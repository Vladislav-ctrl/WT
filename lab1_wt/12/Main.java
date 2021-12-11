import task12.comparator.ComparatorAuthorName;
import task12.comparator.ComparatorName;
import task12.comparator.ComparatorNameAuthor;
import task12.comparator.ComparatorAuthorNamePrice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Book book1 = new Book("Познай мир", "Другой автор", 120, 10);
        Book book2 = new Book("Познай мир", "Другой автор", 100, 3);
        Book book3 = new ProgrammerBook("Java From EPAM", "Кто-то очень умный", 500, 1, "Java", 9);
        Book book4 = new ProgrammerBook("C#", "Еще один автор", 180, 2, "С#", 8);
        Book book5 = new ProgrammerBook("Все о C++", "Автор2", 200, 8, "C++", 7);
        List<Book> list = new ArrayList<>();
        list.add(book1);
        list.add(book2);
        list.add(book3);
        list.add(book4);
        list.add(book5);
        System.out.println("----------- isbn -------------------------");
        printList(list);
        System.out.println("----------- title -------------------------");
        Collections.sort(list, new ComparatorName());
        printList(list);
        System.out.println("----------- title and author  -------------------------");
        Collections.sort(list, new ComparatorNameAuthor());
        printList(list);
        System.out.println("----------- author and title  -------------------------");
        Collections.sort(list, new ComparatorAuthorName());
        printList(list);
        System.out.println("----------- author and title and price  -------------------------");
        Collections.sort(list, new ComparatorAuthorNamePrice());
        printList(list);
    }

    private static <T extends Book> void printList(List<T> list) {
        for (T el : list) {
            System.out.println(el);
        }
    }

}
