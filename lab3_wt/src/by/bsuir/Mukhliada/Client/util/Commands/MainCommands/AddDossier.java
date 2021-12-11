package by.bsuir.Mukhliada.Client.util.Commands.MainCommands;

import by.bsuir.Mukhliada.Client.util.Commands.MainCommand;
import by.bsuir.Mukhliada.Client.util.Controllers.Controller;

public class AddDossier implements MainCommand {

    public AddDossier() { }

    @Override
    public void Execute(Controller controller){
        controller.dossierController.addDossier(controller.currentUser);
    }
}
