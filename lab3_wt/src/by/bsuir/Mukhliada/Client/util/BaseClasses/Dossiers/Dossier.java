package by.bsuir.Mukhliada.Client.util.BaseClasses.Dossiers;

import java.io.Serializable;
import java.time.LocalDate;

public class Dossier implements Serializable {
    private String surname = "";
    private String name = "";
    private String secondName = "";
    private String data = "";
    private LocalDate birthDate;
    private int dossierID = 0;
    private static int count = 0;

    public Dossier(String surname, String name, String secondName, LocalDate birthDate, String data) {
        this.surname = surname;
        this.name = name;
        this.secondName = secondName;
        this.birthDate = birthDate;
        this.data = data;
        dossierID = count++;
    }

    public void setSurname(String surname) { this.surname = surname; }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public String getSecondName() { return secondName; }

    public void setSecondName(String secondName) { this.secondName = secondName; }

    public LocalDate getBirthDate() { return birthDate; }

    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

    public void setDossierID(int dossierID) { this.dossierID = dossierID; }

    public int getDossierID() {
        return dossierID;
    }

    public static void setCount(int DBCount) { count = DBCount; }

    public static int getCount() { return count; }

    @Override
    public String toString() {
        return "ID: " + dossierID + "; surname: " + surname + "; name: " +
                name + "; secondname: " + secondName + "; birthdate: " + birthDate.toString();
    }
}
