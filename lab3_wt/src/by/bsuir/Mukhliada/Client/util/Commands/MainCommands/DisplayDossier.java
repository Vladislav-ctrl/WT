package by.bsuir.Mukhliada.Client.util.Commands.MainCommands;

import by.bsuir.Mukhliada.Client.util.BaseClasses.Dossiers.Dossier;
import by.bsuir.Mukhliada.Client.util.Commands.MainCommand;
import by.bsuir.Mukhliada.Client.util.Controllers.Controller;
import by.bsuir.Mukhliada.Client.util.View.View;

public class DisplayDossier implements MainCommand {

    public DisplayDossier() { }


    @Override
    public void Execute(Controller controller) {
        Dossier dossier = controller.dossierController.getDossierById();
        if (dossier != null) {
            View.displayDossier(dossier);
        }
    }
}
