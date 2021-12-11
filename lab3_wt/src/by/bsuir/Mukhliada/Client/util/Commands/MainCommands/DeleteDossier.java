package by.bsuir.Mukhliada.Client.util.Commands.MainCommands;

import by.bsuir.Mukhliada.Client.util.Commands.MainCommand;
import by.bsuir.Mukhliada.Client.util.Controllers.Controller;

public class DeleteDossier implements MainCommand {
    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void Execute(Controller controller) {
        controller.dossierController.deleteDossier(controller.currentUser);
    }

    public DeleteDossier() {

    }
}
