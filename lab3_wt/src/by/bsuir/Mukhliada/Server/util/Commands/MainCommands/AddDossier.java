package by.bsuir.Mukhliada.Server.util.Commands.MainCommands;

import by.bsuir.Mukhliada.Client.util.BaseClasses.Dossiers.Dossier;
import by.bsuir.Mukhliada.Server.util.Commands.MainCommand;
import by.bsuir.Mukhliada.Server.util.Controllers.Controller;
import com.google.gson.Gson;

public class AddDossier implements MainCommand {

    public AddDossier() { }

    @Override
    synchronized public String Execute(Controller controller, String parameter, boolean adminPrivileges) {
        if (!adminPrivileges) {
            return "Access denied!";
        }

        Gson gson = new Gson();

        Dossier dossier = gson.fromJson(parameter, Dossier.class);

        if (!controller.dossierController.addDossier(dossier)) {
            return "Error in adding dossier!";
        }

        return "Added successfully!";
    }
}
