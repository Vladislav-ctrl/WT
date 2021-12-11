package by.bsuir.Mukhliada.Client.util.DAO;

import by.bsuir.Mukhliada.Client.util.BaseClasses.Dossiers.Dossier;
import by.bsuir.Mukhliada.Client.util.BaseClasses.Message;
import by.bsuir.Mukhliada.Client.util.BaseClasses.Users.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DossiersDAO extends DAO<Dossier> {
    private MessageTransporter socket;
    private Gson gson;

    public DossiersDAO() {
        try {
            socket = new MessageTransporter();
        } catch (IOException e) {
            System.out.println("Error in dossier socket creation");
        }

        gson = new Gson();
    }

    @Override
    public List<Dossier> getAll() {
        Message message = new Message("getAllDossiers", "", "");
        String strMessage = gson.toJson(message);
        socket.SendMessage(strMessage);
        strMessage = socket.GetAnswer();

        try {
            return gson.fromJson(strMessage, new TypeToken<ArrayList<Dossier>>(){}.getType());
        } catch (Exception e) {
            System.out.println("Wrong command from server!");
            return null;
        }
    }

    @Override
    public Dossier getEntityById(Integer id) {
        Message message = new Message("getDossierById", id.toString(), "");
        String strMessage = gson.toJson(message);
        socket.SendMessage(strMessage);
        strMessage = socket.GetAnswer();

        try {
            return gson.fromJson(strMessage, Dossier.class);
        } catch (Exception e) {
            System.out.println("Wrong command from server!");
            return null;
        }
    }

    @Override
    public Dossier update(Dossier entity, User user) {
        Message message = new Message("updateDossier", gson.toJson(entity), gson.toJson(user));
        String strMessage = gson.toJson(message);
        socket.SendMessage(strMessage);
        strMessage = socket.GetAnswer();

        System.out.println(strMessage);
        return null;
    }

    public Dossier updateName(String name, int ID, User user) {
        Dossier dossier = getEntityById(ID);
        dossier.setName(name);
        return update(dossier, user);
    }
    public Dossier updateSurname(String surname, int ID, User user) {
        Dossier dossier = getEntityById(ID);
        dossier.setSurname(surname);
        return update(dossier, user);
    }
    public Dossier updateSecondname(String secondname, int ID, User user) {
        Dossier dossier = getEntityById(ID);
        dossier.setSecondName(secondname);
        return update(dossier, user);
    }
    public Dossier updateBirthdate(LocalDate birthdate, int ID, User user) {
        Dossier dossier = getEntityById(ID);
        dossier.setBirthDate(birthdate);
        return update(dossier, user);
    }
    public Dossier updateData(String data, int ID, User user) {
        Dossier dossier = getEntityById(ID);
        dossier.setData(data);
        return update(dossier, user);
    }

    @Override
    public boolean delete(Integer id, User user) {
        Message message = new Message("deleteDossier", id.toString(), gson.toJson(user));
        String strMessage = gson.toJson(message);
        socket.SendMessage(strMessage);
        strMessage = socket.GetAnswer();
        System.out.println(strMessage);

        return !strMessage.equals("Deleted successfully!");
    }

    @Override
    public boolean create(Dossier entity, User user) {
        Message message = new Message("createDossier", gson.toJson(entity), gson.toJson(user));
        String strMessage = gson.toJson(message);
        socket.SendMessage(strMessage);
        strMessage = socket.GetAnswer();
        System.out.println(strMessage);

        return strMessage.equals("Added successfully!");
    }

    @Override
    public void close() {
        try {
            socket.SendMessage("exit");
            socket.close();
        } catch (IOException e) {
            System.out.println("Error in dossier socket closing");
        }
    }
}
