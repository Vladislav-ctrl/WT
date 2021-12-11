package by.bsuir.Mukhliada.Client.util.Commands.EditingCommands;

import by.bsuir.Mukhliada.Client.util.BaseClasses.Users.User;
import by.bsuir.Mukhliada.Client.util.Commands.UpdateCommand;
import by.bsuir.Mukhliada.Client.util.Controllers.DossierController;
import by.bsuir.Mukhliada.Client.util.View.View;

public class UpdateSecondname implements UpdateCommand {
    public UpdateSecondname() {
    }

    @Override
    public boolean Execute(DossierController dossierController, int ID, User user) {
        String secondname = dossierController.console.getFullName("secondname");
        dossierController.dossiersDAO.updateSecondname(secondname, ID, user);
        return false;
    }
}
