package by.bsuir.Mukhliada.util.Commands;

import by.bsuir.Mukhliada.runner.Library;
import by.bsuir.Mukhliada.util.BaseClasses.Books.Book;
import by.bsuir.Mukhliada.util.BaseClasses.Books.BookType;
import by.bsuir.Mukhliada.util.BaseClasses.Users.Roles;
import by.bsuir.Mukhliada.util.BaseClasses.Users.User;
import by.bsuir.Mukhliada.util.Controllers.BookController;
import by.bsuir.Mukhliada.util.Controllers.UserController;
import by.bsuir.Mukhliada.util.View.View;
import by.bsuir.Mukhliada.util.Email.EmailService;

import java.util.ArrayList;
import java.util.List;

public class CommandAction {
    private static CommandReader cmdReader;
    private static BookController bookController;
    private static UserController userController;

    static  {
        cmdReader = new CommandReader();
        bookController = new BookController();
        userController = new UserController();
        Library.setCurrentBooksDisplayed(bookController.getAllBooks());
    }

    public static User getAdmin() {
        return userController.getUser(0);
    }


    public static void updateList(List lst) {
        Library.setPageNumber(0);
        if (lst == null){
            Library.setCurrentBooksDisplayed(bookController.getAllBooks());
        } else {
            Library.setCurrentBooksDisplayed(lst);
        }
    }

    private static boolean haveAdminRights(User user){
        if (user.getRole() == Roles.Administrator){
            return true;
        } else {
            return false;
        }
    }

    public static List search(Commands type) {
        System.out.print("Type search request: ");
        String request = cmdReader.getLine();

        List lst = bookController.search(type, request);

        if (lst.size() == 0) {
            System.out.println("Nothing found!");
            return new ArrayList();
        } else {
            System.out.println("Search results: ");
            return lst;
        }
    }

    public static int nextPage(List lst, int currPage) {
        if (currPage * View.getPAGESIZE() > lst.size())
            currPage--;

        return View.displayPage(lst, currPage);
    }

    public static int previousPage(List lst, int currPage) {
        currPage -= 2;

        if (currPage < 0)
            currPage = 0;

        return View.displayPage(lst, currPage);
    }

    public static boolean editBook(User user){
        if (haveAdminRights(user)) {
            boolean continueEditing = true;

            System.out.print("Changing book. ");
            int id = cmdReader.getID();

            while (continueEditing) {
                System.out.println("Type Stop to exit editing mode.");
                System.out.print("Type what do you want to change(Title/Author/Desc/Type): ");
                ModCommands cmd = cmdReader.getModCommand();

                switch (cmd){
                    case Author:
                        String author = cmdReader.getBookAuthor();
                        continueEditing = bookController.changeAuthor(id, author);
                        break;
                    case Desc:
                        String description = cmdReader.getBookDescription();
                        continueEditing = bookController.changeDescription(id, description);
                        break;
                    case Title:
                        String title = cmdReader.getBookTitle();
                        continueEditing = bookController.changeTitle(id, title);
                        break;
                    case Type:
                        BookType bookType = cmdReader.getBookType();
                        continueEditing = bookController.changeBookType(id, bookType);
                        break;
                    case Help:
                        System.out.println("Type Title/Author/Desc/Type to edit it.\nType Stop to exit from editing.");
                        break;
                    case Stop:
                        System.out.println("Editing ended.");
                        return true;
                }
            }

            return false;
        } else {
            System.out.println("You are not admin.");
        }
        return false;
    }

    public static boolean addNewBook(User user){
        if (haveAdminRights(user)) {
            String title = cmdReader.getBookTitle();
            String author = cmdReader.getBookAuthor();
            BookType bookType = cmdReader.getBookType();
            String description = cmdReader.getBookDescription();

            String message = "New book in library!\n" + title + '\n' + author + '\n' + description;

            List<String> list = userController.getAllEmails();
            if (list.size() > 0) {
                EmailService.sendMessage(message, list);
            }

            return bookController.addBook(title, author, description, bookType);
        } else {
            System.out.println("You are not admin.");
        }
        return false;
    }

    public static boolean deleteBook(User user){
        if (haveAdminRights(user)) {
            int id = cmdReader.getID();
            if (!bookController.deleteBook(id)){
                System.out.println("No such ID!");
                return false;
            } else {
                System.out.println("Book deleted!");
                return true;
            }
        } else {
            System.out.println("You are not admin.");
        }
        return false;
    }

    public static User logIn() {

        System.out.println("Logging In:");
        boolean continueLogIn = true;
        while (continueLogIn) {
            String userEmail = cmdReader.getUserEmail();
            String userPassword = cmdReader.getUserPassword();

            User user = userController.logIn(userEmail, userPassword);
            if (user != null) {
                System.out.println("Logged In.");
                return user;
            }

            System.out.println("Incorrect login or password!");
            System.out.println("Try again?");
            continueLogIn = cmdReader.getAnswer();
        }

        return null;
    }


    public static boolean registration() {

        System.out.println("Registration:");
        boolean continueRegister = true;

        while (continueRegister) {
            String userEmail = cmdReader.getUserEmail();
            String userPassword = cmdReader.getUserPassword();
            System.out.print("Enter login: ");
            String userName = cmdReader.getLine();

            boolean registered = userController.Register(userName, userPassword, userEmail, Roles.User);

            if (registered) {
                System.out.println("Registered successfully.");
                return true;
            }

            System.out.println("Try again?");
            continueRegister = cmdReader.getAnswer();
        }

        return false;
    }

    public static void showDescription() {
        int id = cmdReader.getID();
        Book book = bookController.getBookById(id);
        if (book != null){
            View.displayDescription(book);
        } else {
            System.out.println("No such ID!");
        }
    }

    public static void offerBook(User user) {
        if (!haveAdminRights(user)) {
            String title = cmdReader.getBookTitle();
            String author = cmdReader.getBookAuthor();
            String description = cmdReader.getBookDescription();

            String message = "I want to see this book in your library!\n" + title + '\n' + author + '\n' + description;

            List<String> list = new ArrayList<>();
            list.add(EmailService.getFrom());
            EmailService.sendMessage(message, list);
        }else {
            System.out.println("You are administrator if you want to add book in library - Just Do It!");
        }
    }

    public static void help(User user) {
        System.out.println("Commands: ");
        System.out.println("PrevPage - Shows previous page.");
        System.out.println("NextPage - Shows next page.");
        System.out.println("Catalog - Display first page of catalog.");
        System.out.println("ShowDescription - Display books description.");
        System.out.println("SearchTitle - Search books by title.");
        System.out.println("SearchAuthor - Search books by author.");
        System.out.println("Exit - Exit from application.");
        /*
        NextPage,
        PrevPage,
        Add,
        Delete,
        Catalog,
        SearchTitle,
        SearchAuthor,
        Exit,
        Edit,
        ShowAll,
        Help,
        ShowDescription,
        Offer
         */

        if (user.getRole() == Roles.Administrator) {
            System.out.println("Only for administrator: ");
            System.out.println("Edit - Edit book.");
            System.out.println("Add - Add new book.");
            System.out.println("Delete - Delete book.");
        } else {
            System.out.println("Offer - Offer book by sending it's title, author's name and description to admins Email.");
        }
    }

    public static void saveBooks() {
        bookController.save();
    }

    public static void saveUsers() {
        userController.save();
    }

}