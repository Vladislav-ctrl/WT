package by.bsuir.Mukhliada.Client.util.Commands.EditingCommands;

import by.bsuir.Mukhliada.Client.util.BaseClasses.Users.User;
import by.bsuir.Mukhliada.Client.util.Commands.UpdateCommand;
import by.bsuir.Mukhliada.Client.util.Controllers.DossierController;

public class StopUpdating implements UpdateCommand {
    public StopUpdating() { }

    @Override
    public boolean Execute(DossierController dossierController, int ID, User user) {
        return true;
    }
}
