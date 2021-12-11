package by.bsuir.Mukhliada.Client.util.Commands.MainCommands;

import by.bsuir.Mukhliada.Client.util.Commands.MainCommand;
import by.bsuir.Mukhliada.Client.util.Controllers.Controller;

public class Exit implements MainCommand {

    @Override
    public void Execute(Controller controller) {
        controller.dossierController.dossiersDAO.close();
        controller.userController.usersDAO.close();
        controller.exitApplication = true;
    }

    public Exit() {
    }
}
