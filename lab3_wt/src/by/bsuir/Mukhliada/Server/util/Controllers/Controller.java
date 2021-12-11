package by.bsuir.Mukhliada.Server.util.Controllers;

public class Controller {
    public final UserController userController;
    public final DossierController dossierController;

    public Controller(UserController userController, DossierController dossierController) {
        this.userController = userController;
        this.dossierController = dossierController;
    }
}
