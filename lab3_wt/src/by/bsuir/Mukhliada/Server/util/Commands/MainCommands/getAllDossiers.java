package by.bsuir.Mukhliada.Server.util.Commands.MainCommands;

import by.bsuir.Mukhliada.Server.util.Commands.MainCommand;
import by.bsuir.Mukhliada.Server.util.Controllers.Controller;
import com.google.gson.Gson;

public class getAllDossiers implements MainCommand {
    public getAllDossiers() { }

    @Override
    public String Execute(Controller controller, String parameter, boolean adminPrivileges) {
        Gson gson = new Gson();
        return gson.toJson(controller.dossierController.getAllDossiers());
    }
}
