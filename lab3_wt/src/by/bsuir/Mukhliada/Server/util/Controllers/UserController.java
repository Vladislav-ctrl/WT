package by.bsuir.Mukhliada.Server.util.Controllers;

import by.bsuir.Mukhliada.Client.util.BaseClasses.Users.User;
import by.bsuir.Mukhliada.Server.util.DAO.UsersDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class UserController {

    private UsersDAO usersDAO;

    public UserController() {
        usersDAO = new UsersDAO();
    }

    private boolean isEmailFree(String email, List<User> users) {

        List result = users.stream().filter(p -> p.getEmail().equals(email))
                .collect(Collectors.toList());

        return result.isEmpty();
    }

    private boolean isValidEmail(String email) {
        final String EMAIL_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                        "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    private User isRegistered(String email, String password, List<User> users) {

        List<User> result = users.stream().filter(p -> p.getEmail().equals(email) && p.getPasswordHash().equals(password))
                .collect(Collectors.toList());

        if (result.size() == 0){
            return null;
        } else {
            return result.get(0);
        }
    }

    public List<User> getAllUsers(){
        return usersDAO.getAll();
    }

    public User getUser(int ID) {
        return usersDAO.getEntityById(ID);
    }

    public User logIn(String email, String password) {
        List<User> list = getAllUsers();

        return isRegistered(email, password, list);
    }

    public boolean Register(User user) {
        List<User> list = getAllUsers();

        if (!isValidEmail(user.getEmail())) {
            return false;
        }

        if(!isEmailFree(user.getEmail(), list)){
            return false;
        }

        int ID = User.getCount();
        user.setId(ID);
        User.setCount(++ID);

        return usersDAO.create(user);
    }

    public List<String> getAllEmails() {
        List<User> usersList = getAllUsers();
        List<String> usersEmails = new ArrayList<>();

        for (User user : usersList){
            usersEmails.add(user.getEmail());
        }

        return usersEmails;
    }

    public void save() {
        usersDAO.close();
    }
}
