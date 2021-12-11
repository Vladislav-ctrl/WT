package by.bsuir.Mukhliada.Client.util.Commands.MainCommands;

import by.bsuir.Mukhliada.Client.util.BaseClasses.Dossiers.Dossier;
import by.bsuir.Mukhliada.Client.util.Commands.MainCommand;
import by.bsuir.Mukhliada.Client.util.Controllers.Controller;
import by.bsuir.Mukhliada.Client.util.View.View;

import java.util.List;

public class DisplayDossiers implements MainCommand {
    public DisplayDossiers() {
    }

    @Override
    public void Execute(Controller controller) {
        List<Dossier> dossiers = controller.dossierController.getAllDossier();
        if (dossiers != null) {
            View.displayFullCatalog(dossiers);
        }
    }
}
