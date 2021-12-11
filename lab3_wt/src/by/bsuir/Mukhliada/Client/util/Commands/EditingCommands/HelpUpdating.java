package by.bsuir.Mukhliada.Client.util.Commands.EditingCommands;

import by.bsuir.Mukhliada.Client.util.BaseClasses.Users.User;
import by.bsuir.Mukhliada.Client.util.Commands.UpdateCommand;
import by.bsuir.Mukhliada.Client.util.Controllers.DossierController;

public class HelpUpdating implements UpdateCommand {
    public HelpUpdating() { }

    @Override
    public boolean Execute(DossierController dossierController, int ID, User user) {
        System.out.println("Type Birthdate to edit it.");
        System.out.println("Type Data to edit it.");
        System.out.println("Type Name to edit it.");
        System.out.println("Type Secondname to edit it.");
        System.out.println("Type Surname to edit it.");
        System.out.println("Type Stop to exit from editing.");
        return false;
    }
}