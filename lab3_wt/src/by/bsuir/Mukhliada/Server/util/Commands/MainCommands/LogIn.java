package by.bsuir.Mukhliada.Server.util.Commands.MainCommands;

import by.bsuir.Mukhliada.Client.util.BaseClasses.Users.User;
import by.bsuir.Mukhliada.Server.util.Commands.MainCommand;
import by.bsuir.Mukhliada.Server.util.Controllers.Controller;
import com.google.gson.Gson;

public class LogIn implements MainCommand {
    public LogIn() { }

    @Override
    public String Execute(Controller controller, String parameter, boolean adminPrivileges) {
        Gson gson = new Gson();

        User user = gson.fromJson(parameter, User.class);
        user = controller.userController.logIn(user.getEmail(), user.getPasswordHash());

        if (user == null) {
            return "Login failed!";
        }

        return gson.toJson(user);
    }
}
