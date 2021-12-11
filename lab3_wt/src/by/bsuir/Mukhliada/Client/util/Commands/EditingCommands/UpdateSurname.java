package by.bsuir.Mukhliada.Client.util.Commands.EditingCommands;

import by.bsuir.Mukhliada.Client.util.BaseClasses.Users.User;
import by.bsuir.Mukhliada.Client.util.Commands.UpdateCommand;
import by.bsuir.Mukhliada.Client.util.Controllers.DossierController;
import by.bsuir.Mukhliada.Client.util.View.View;

public class UpdateSurname implements UpdateCommand {
    public UpdateSurname() { }

    @Override
    public boolean Execute(DossierController dossierController, int ID, User user) {
        String surname = dossierController.console.getFullName("surname");
        dossierController.dossiersDAO.updateSurname(surname, ID, user);
        return false;
    }
}
