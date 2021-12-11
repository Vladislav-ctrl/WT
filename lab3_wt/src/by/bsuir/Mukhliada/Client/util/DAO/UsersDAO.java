package by.bsuir.Mukhliada.Client.util.DAO;

import by.bsuir.Mukhliada.Client.util.BaseClasses.Message;
import by.bsuir.Mukhliada.Client.util.BaseClasses.Users.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO extends DAO<User> {
    private MessageTransporter socket;
    private Gson gson;

    public UsersDAO() {
        try {
            socket = new MessageTransporter();
        } catch (IOException e) {
            System.out.println("Error in user socket creation");
        }

        gson = new Gson();
    }

    public boolean register(User user) {
        Message message = new Message("register", gson.toJson(user), "");
        String strMessage = gson.toJson(message);
        socket.SendMessage(strMessage);
        strMessage = socket.GetAnswer();

        if (strMessage.equals("Registered!")) {
            return true;
        }

        return false;
    }

    public User logIn(User user) {
        Message message = new Message("login", gson.toJson(user), "");
        String strMessage = gson.toJson(message);
        socket.SendMessage(strMessage);
        strMessage = socket.GetAnswer();

        try {
            return gson.fromJson(strMessage, User.class);
        } catch (Exception e) {
            System.out.println(strMessage);
            return null;
        }
    }


    @Override
    public List<User> getAll() {
        Message message = new Message("getAllUsers", "", "");
        String strMessage = gson.toJson(message);
        socket.SendMessage(strMessage);
        strMessage = socket.GetAnswer();

        try {
            List<User> users = gson.fromJson(strMessage, new TypeToken<ArrayList<User>>(){}.getType());
            return users;
        } catch (Exception e) {
            System.out.println("Wrong command from server!");
            return null;
        }
    }

    @Override
    public User getEntityById(Integer id) {
        Message message = new Message("getUserById", id.toString(), "");
        String strMessage = gson.toJson(message);
        socket.SendMessage(strMessage);
        strMessage = socket.GetAnswer();

        try {
            User user = gson.fromJson(strMessage, User.class);
            return user;
        } catch (Exception e) {
            System.out.println("Wrong command from server!");
            return null;
        }
    }

    @Override
    public User update(User entity, User user) {
        Message message = new Message("updateUser", gson.toJson(entity), gson.toJson(user));
        String strMessage = gson.toJson(message);
        socket.SendMessage(strMessage);
        strMessage = socket.GetAnswer();

        try {
            User oldUser = gson.fromJson(strMessage, User.class);
            return oldUser;
        } catch (Exception e) {
            System.out.println("Wrong command from server!");
            return null;
        }
    }

    public User updateEmail(String email, int ID, User user) {
        User updUser = getEntityById(ID);
        updUser.setEmail(email);
        return update(updUser, user);
    }

    public User updatePassword(String password, int ID, User user) {
        User updUser = getEntityById(ID);
        updUser.setPassword(password);
        return update(updUser, user);
    }

    @Override
    public boolean delete(Integer id, User user) {
        Message message = new Message("deleteUser", id.toString(), gson.toJson(user));
        String strMessage = gson.toJson(message);
        socket.SendMessage(strMessage);
        strMessage = socket.GetAnswer();
        return !strMessage.equals("");
    }

    @Override
    public boolean create(User entity, User user) {
        Message message = new Message("createUser", gson.toJson(entity), gson.toJson(user));
        String strMessage = gson.toJson(message);
        socket.SendMessage(strMessage);
        strMessage = socket.GetAnswer();
        return !strMessage.equals("");
    }

    @Override
    public void close() {
        try {
            socket.SendMessage("exit");
            socket.close();
        } catch (IOException e) {
            System.out.println("Error in user socket closing");
        }
    }
}
