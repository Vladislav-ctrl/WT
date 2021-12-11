package by.bsuir.Mukhliada.util.BaseClasses.Users;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private String login = "";
    private String email = "";
    private Roles role = Roles.User;
    private String pswrdHash = "";
    private int id = 0;
    private static int count = 0;

    public User(String login, String email, Roles role, String pswrdHash) {
        this.login = login;
        this.email = email;
        this.role = role;
        this.pswrdHash = String.valueOf(pswrdHash.hashCode());;
        id = count++;
    }

    public User() { }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public Roles getRole() {
        return role;
    }

    public String getPswrdHash() {
        return pswrdHash;
    }

    public int getId() {
        return id;
    }

    public static void setCount(int DBCount) { count = DBCount; }

    @Override
    public String toString() {
        return "ID: " + id + "; login: " + login + "; Email: " + email + "; role: " + role.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return login.equals(user.login) &&
                email.equals(user.email) &&
                role == user.role &&
                pswrdHash.equals(user.pswrdHash);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, email, role, pswrdHash);
    }
}