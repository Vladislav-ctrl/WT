package by.bsuir.Mukhliada.Server.util.Commands.MainCommands;

import by.bsuir.Mukhliada.Client.util.BaseClasses.Users.User;
import by.bsuir.Mukhliada.Server.util.Commands.MainCommand;
import by.bsuir.Mukhliada.Server.util.Controllers.Controller;
import com.google.gson.Gson;

public class Registration implements MainCommand {
    public Registration() { }

    @Override
    public String Execute(Controller controller, String parameter, boolean adminPrivileges) {
        Gson gson = new Gson();
        User user = gson.fromJson(parameter, User.class);

        if (controller.userController.Register(user)){
            return "Registered!";
        }

        return "Registration failed!";
    }
}
