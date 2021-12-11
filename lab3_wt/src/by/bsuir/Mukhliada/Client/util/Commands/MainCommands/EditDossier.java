package by.bsuir.Mukhliada.Client.util.Commands.MainCommands;

import by.bsuir.Mukhliada.Client.util.Commands.MainCommand;
import by.bsuir.Mukhliada.Client.util.Controllers.Controller;

public class EditDossier implements MainCommand {
    @Override
    public void Execute(Controller controller) {
        controller.dossierController.editDossier(controller.currentUser);
    }

    public EditDossier() {
    }
}
