package by.bsuir.Mukhliada.Client.util.Commands;

import by.bsuir.Mukhliada.Client.util.BaseClasses.Users.User;
import by.bsuir.Mukhliada.Client.util.Controllers.DossierController;

public interface UpdateCommand {
    boolean Execute(DossierController dossierController, int ID, User user);
}
