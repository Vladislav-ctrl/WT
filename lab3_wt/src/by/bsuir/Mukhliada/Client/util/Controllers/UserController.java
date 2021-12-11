package by.bsuir.Mukhliada.Client.util.Controllers;

import by.bsuir.Mukhliada.Client.util.BaseClasses.Users.Roles;
import by.bsuir.Mukhliada.Client.util.BaseClasses.Users.User;
import by.bsuir.Mukhliada.Client.util.Commands.CommandReader;
import by.bsuir.Mukhliada.Client.util.DAO.UsersDAO;

public class UserController{
    public UsersDAO usersDAO;
    public CommandReader console;

    public UserController(CommandReader cmdReader) {
        usersDAO = new UsersDAO();
        console = cmdReader;
    }

    public User getAdmin() {
        return getUser(0);
    }

    public User getUser(int ID) {
        User user = usersDAO.getEntityById(ID);
        if (user == null) {
            System.out.println("No user with such id.");
        }
        return user;
    }

    public boolean registration() {

        System.out.println("Registration:");
        boolean continueRegister = true;

        while (continueRegister) {
            String userEmail = console.getUserEmail();
            String userPassword = console.getUserPassword();
            User user = new User(userEmail, Roles.User, userPassword);
            boolean registered = usersDAO.register(user);

            if (registered) {
                System.out.println("Registered successfully.");
                return true;
            }

            System.out.println("Try again?");
            continueRegister = console.getAnswer();
        }

        return false;
    }


    public User logIn() {

        System.out.println("Logging In:");
        boolean continueLogIn = true;

        while (continueLogIn) {
            String userEmail = console.getUserEmail();
            String userPassword = console.getUserPassword();
            User user = new User(userEmail, Roles.User, userPassword);
            user = usersDAO.logIn(user);

            if (user != null) {
                System.out.println("Logged In.");
                return user;
            }

            System.out.println("Incorrect login or password!");
            System.out.println("Try again?");
            continueLogIn = console.getAnswer();
        }

        return null;
    }

}
