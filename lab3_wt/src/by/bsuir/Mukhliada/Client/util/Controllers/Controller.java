package by.bsuir.Mukhliada.Client.util.Controllers;

import by.bsuir.Mukhliada.Client.util.BaseClasses.Users.User;

public class Controller {
    public final DossierController dossierController;
    public final UserController userController;
    public boolean exitApplication;
    public User currentUser;

    public Controller(DossierController dossierController, UserController userController) {
        this.dossierController = dossierController;
        this.userController = userController;
        exitApplication = false;
        currentUser = null;
    }
}
