package by.bsuir.Mukhliada.Client.util.Controllers;

import by.bsuir.Mukhliada.Client.util.BaseClasses.Dossiers.Dossier;
import by.bsuir.Mukhliada.Client.util.BaseClasses.Users.User;
import by.bsuir.Mukhliada.Client.util.Commands.CommandReader;
import by.bsuir.Mukhliada.Client.util.Commands.UpdateCommand;
import by.bsuir.Mukhliada.Client.util.DAO.DossiersDAO;

import java.time.LocalDate;
import java.util.List;

public class DossierController {

    public final DossiersDAO dossiersDAO;
    public final CommandReader console;

    public DossierController(CommandReader cmdReader) {
        dossiersDAO = new DossiersDAO();
        console = cmdReader;
    }

    public void editDossier(User user){
        Dossier dossier = getDossierById();
        if (dossier == null) {
            return;
        }
        int ID = dossier.getDossierID();

        System.out.println("Editing begins");
        boolean stopUpdating = false;

        while (!stopUpdating) {
            System.out.println("Type Stop to exit editing mode.");
            System.out.print("Type what do you want to change(help - all commands): ");
            UpdateCommand cmd = console.getUpdateCommand();
            stopUpdating = cmd.Execute(this, ID, user);
        }

        System.out.println("Editing ends");
    }

    public void addDossier(User user) {
        String name = console.getFullName("name");
        String surname = console.getFullName("surname");
        String secondname = console.getFullName("secondname");
        String data = console.getData();
        LocalDate birthdate = console.getDate();

        Dossier dossier = new Dossier(surname, name, secondname, birthdate, data);
        dossiersDAO.create(dossier, user);
    }

    public void deleteDossier(User user) {
        int ID = console.getID();
        dossiersDAO.delete(ID, user);
    }

    public Dossier getDossierById() {
        int ID = console.getID();
        Dossier dossier = dossiersDAO.getEntityById(ID);

        if (dossier == null) {
            System.out.println("No dossier with such id.");
        }

        return dossier;
    }

    public List<Dossier> getAllDossier(){
        return dossiersDAO.getAll();
    }
}
