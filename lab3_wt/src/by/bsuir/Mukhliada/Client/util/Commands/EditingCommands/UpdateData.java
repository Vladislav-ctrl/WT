package by.bsuir.Mukhliada.Client.util.Commands.EditingCommands;

import by.bsuir.Mukhliada.Client.util.BaseClasses.Users.User;
import by.bsuir.Mukhliada.Client.util.Commands.UpdateCommand;
import by.bsuir.Mukhliada.Client.util.Controllers.DossierController;
import by.bsuir.Mukhliada.Client.util.View.View;

public class UpdateData implements UpdateCommand {
    public UpdateData() { }

    @Override
    public boolean Execute(DossierController dossierController, int ID, User user) {
        String data = dossierController.console.getData();
        dossierController.dossiersDAO.updateData(data, ID, user);
        return false;
    }
}
