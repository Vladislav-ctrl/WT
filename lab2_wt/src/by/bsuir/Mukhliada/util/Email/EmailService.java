package by.bsuir.Mukhliada.util.Email;


import java.util.List;

public class EmailService {
    private static String from = "BookLibrary@gmail.com";

    public static void sendMessage(String message, List<String> usersEmails) {
        System.out.println("Emails send to " + usersEmails.size() + " users");
    }

    public static void setFrom(String from) {
        EmailService.from = from;
    }

    public static String getFrom() {
        return from;
    }
}