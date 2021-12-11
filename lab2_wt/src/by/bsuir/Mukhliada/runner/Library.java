package by.bsuir.Mukhliada.runner;

import by.bsuir.Mukhliada.util.BaseClasses.Users.Roles;
import by.bsuir.Mukhliada.util.BaseClasses.Users.User;
import by.bsuir.Mukhliada.util.Commands.Commands;
import by.bsuir.Mukhliada.util.Commands.CommandAction;
import by.bsuir.Mukhliada.util.Commands.CommandReader;
import by.bsuir.Mukhliada.util.View.View;

import java.util.List;


public class Library {
    private static Integer pageNumber = 0;
    private static List currentBooksDisplayed;

    public static void setPageNumber(Integer pageNumber) {
        Library.pageNumber = pageNumber;
    }

    public static void setCurrentBooksDisplayed(List currentBooksDisplayed) {
        Library.currentBooksDisplayed = currentBooksDisplayed;
    }

    public static void main(String[] args) {
        User currentUser = null;
        CommandReader cmdReader = new CommandReader();
        boolean exit = false;

//        currentUser = CommandAction.getAdmin();

        while(currentUser == null) {
            System.out.println("Do you want to register?");
            if (cmdReader.getAnswer()) {
                CommandAction.registration();
            } else {
                currentUser = CommandAction.logIn();
            }
        }

        CommandAction.help(currentUser);

        while (!exit){
            System.out.print("Type command: ");
            Commands cmd = cmdReader.getCommand();

            switch (cmd){
                case Exit:
                    exit = true;
                    break;
                case NextPage:
                    pageNumber = CommandAction.nextPage(currentBooksDisplayed, pageNumber);
                    break;
                case PrevPage:
                    pageNumber = CommandAction.previousPage(currentBooksDisplayed, pageNumber);
                    break;
                case Add:
                    CommandAction.addNewBook(currentUser);
                    CommandAction.updateList(null);
                    break;
                case Delete:
                    CommandAction.deleteBook(currentUser);
                    CommandAction.updateList(null);
                    break;
                case Catalog:
                    CommandAction.updateList(null);
                    pageNumber = View.displayPage(currentBooksDisplayed, pageNumber);
                    break;
                case Edit:
                    CommandAction.editBook(currentUser);
                    CommandAction.updateList(null);
                    break;
                case ShowAll:
                    CommandAction.updateList(null);
                    View.displayFullCatalog(currentBooksDisplayed);
                    break;
                case SearchTitle:
                    CommandAction.updateList(CommandAction.search(Commands.SearchTitle));
                    pageNumber = View.displayPage(currentBooksDisplayed, pageNumber);
                    break;
                case SearchAuthor:
                    CommandAction.updateList(CommandAction.search(Commands.SearchAuthor));
                    pageNumber = View.displayPage(currentBooksDisplayed, pageNumber);
                    break;
                case ShowDescription:
                    CommandAction.showDescription();
                    break;
                case Offer:
                    CommandAction.offerBook(currentUser);
                    break;
                case Help:
                    CommandAction.help(currentUser);
                    break;
            }
        }



        CommandAction.saveUsers();

        if (currentUser.getRole() == Roles.Administrator) {
            System.out.println("Do you want to save changes in catalog?");
            if (cmdReader.getAnswer()) {
                CommandAction.saveBooks();
            }
        }
    }
}

