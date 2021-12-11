package by.bsuir.Mukhliada.Client.util.Commands.EditingCommands;

import by.bsuir.Mukhliada.Client.util.BaseClasses.Users.User;
import by.bsuir.Mukhliada.Client.util.Commands.UpdateCommand;
import by.bsuir.Mukhliada.Client.util.Controllers.DossierController;
import by.bsuir.Mukhliada.Client.util.View.View;

import java.time.LocalDate;

public class UpdateBirthDate implements UpdateCommand {
    public UpdateBirthDate() { }

    @Override
    public boolean Execute(DossierController dossierController, int ID, User user) {
        LocalDate localDate = dossierController.console.getDate();
        dossierController.dossiersDAO.updateBirthdate(localDate, ID, user);
        return false;
    }
}
