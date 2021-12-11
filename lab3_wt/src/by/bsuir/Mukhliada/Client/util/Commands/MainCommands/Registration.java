package by.bsuir.Mukhliada.Client.util.Commands.MainCommands;

import by.bsuir.Mukhliada.Client.util.Commands.MainCommand;
import by.bsuir.Mukhliada.Client.util.Controllers.Controller;

public class Registration implements MainCommand {
    public Registration() { }

    @Override
    public void Execute(Controller controller) {
        controller.userController.registration();
    }
}
