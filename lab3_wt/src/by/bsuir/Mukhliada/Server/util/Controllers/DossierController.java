package by.bsuir.Mukhliada.Server.util.Controllers;

import by.bsuir.Mukhliada.Client.util.BaseClasses.Dossiers.Dossier;
import by.bsuir.Mukhliada.Server.util.DAO.DossiersDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DossierController {

    private DossiersDAO dossiersDAO;

    public DossierController() {
        dossiersDAO = new DossiersDAO();
    }

    public List<Dossier> getAllDossiers(){
        return dossiersDAO.getAll();
    }

    public boolean addDossier(Dossier dossier) {
        int ID = Dossier.getCount();
        dossier.setDossierID(ID);
        Dossier.setCount(++ID);
        return dossiersDAO.create(dossier);
    }

    public boolean deleteDossier(int ID) {
        return dossiersDAO.delete(ID);
    }

    public boolean updateDossier(Dossier dossier) {
        return dossiersDAO.update(dossier) != null;
    }

    public List<Dossier> search(String request) {

        List<Dossier> result = new ArrayList<Dossier>();
        List<Dossier> searchIn = dossiersDAO.getAll();

        result = searchIn.stream().filter(p -> p.getSurname().equals(request)).collect(Collectors.toList());

        return result;
    }

    public Dossier getDossierById(int ID) {
        return dossiersDAO.getEntityById(ID);
    }

    public void save(){
        dossiersDAO.close();
    }
}
