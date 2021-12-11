package by.bsuir.Mukhliada.Server.util.Commands.MainCommands;

import by.bsuir.Mukhliada.Server.util.Commands.MainCommand;
import by.bsuir.Mukhliada.Server.util.Controllers.Controller;
import com.google.gson.Gson;

public class getDossier implements MainCommand {
    public getDossier() { }

    @Override
    public String Execute(Controller controller, String parameter, boolean adminPrivileges) {
        Gson gson = new Gson();
        int id = Integer.parseInt(parameter);
        return gson.toJson(controller.dossierController.getDossierById(id));
    }
}
