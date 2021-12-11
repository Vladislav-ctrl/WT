package by.bsuir.Mukhliada.Client.util.BaseClasses.Users;

import java.io.Serializable;

public class User implements Serializable {
    private String email = "";
    private Roles role = Roles.User;
    private String passwordHash = "";
    private int id = 0;
    private static int count = 0;

    public User(String email, Roles role, String password) {
        this.email = email;
        this.role = role;
        this.passwordHash = String.valueOf(password.hashCode());
        id = count++;
    }

    public void setEmail(String email) { this.email = email; }

    public String getEmail() {
        return email;
    }

    public void setRole(Roles role) { this.role = role; }

    public Roles getRole() {
        return role;
    }

    public void setPassword(String password) { this.passwordHash = String.valueOf(password.hashCode()); }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setId(int ID) {
        id = ID;
    }

    public int getId() {
        return id;
    }

    public static void setCount(int DBCount) { count = DBCount; }

    public static int getCount() { return count; }

    @Override
    public String toString() {
        return "ID: " + id + "; Email: " + email + "; role: " + role.toString();
    }
}