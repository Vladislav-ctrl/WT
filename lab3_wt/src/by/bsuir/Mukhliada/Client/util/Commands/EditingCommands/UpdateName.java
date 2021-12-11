package by.bsuir.Mukhliada.Client.util.Commands.EditingCommands;

import by.bsuir.Mukhliada.Client.util.BaseClasses.Users.User;
import by.bsuir.Mukhliada.Client.util.Commands.UpdateCommand;
import by.bsuir.Mukhliada.Client.util.Controllers.DossierController;
import by.bsuir.Mukhliada.Client.util.View.View;

public class UpdateName implements UpdateCommand {
    public UpdateName() { }

    @Override
    public boolean Execute(DossierController dossierController, int ID, User user) {
        String name = dossierController.console.getFullName("name");
        dossierController.dossiersDAO.updateName(name, ID, user);
        return false;
    }
}
