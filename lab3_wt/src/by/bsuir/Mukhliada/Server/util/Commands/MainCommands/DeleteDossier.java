package by.bsuir.Mukhliada.Server.util.Commands.MainCommands;

import by.bsuir.Mukhliada.Server.util.Commands.MainCommand;
import by.bsuir.Mukhliada.Server.util.Controllers.Controller;

public class DeleteDossier implements MainCommand {
    public DeleteDossier() { }

    @Override
    synchronized public String Execute(Controller controller, String parameter, boolean adminPrivileges) {
        if (!adminPrivileges) {
            return "Access denied!";
        }

        try {
            int id = Integer.parseInt(parameter);
            controller.dossierController.deleteDossier(id);
            return "Deleted successfully!";

        } catch (Exception e) {
            return "Error in input params!";
        }
    }
}
