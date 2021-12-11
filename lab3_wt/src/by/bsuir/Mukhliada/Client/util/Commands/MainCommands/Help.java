package by.bsuir.Mukhliada.Client.util.Commands.MainCommands;

import by.bsuir.Mukhliada.Client.util.Commands.MainCommand;
import by.bsuir.Mukhliada.Client.util.Controllers.Controller;

public class Help implements MainCommand {

    @Override
    public void Execute(Controller controller) {
        System.out.println("Commands: ");
        System.out.println("display all - Display all dossiers.");
        System.out.println("display dossier - Display one dossier.");
        // System.out.println("Search - Search dossier.");
        System.out.println("exit - Exit from application.");

        System.out.println("  Only for administrator: ");
        System.out.println("    edit - Edit dossier.");
        System.out.println("    add - Add new dossier.");
        System.out.println("    delete - Delete dossier.");
    }

    public Help() { }
}