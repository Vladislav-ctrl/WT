package by.bsuir.Mukhliada.Client.util.View;

import by.bsuir.Mukhliada.Client.util.BaseClasses.Dossiers.Dossier;

import java.util.List;

public class View {

    public static void displayDossier(Dossier dossier) {
        System.out.println(dossier.toString());
        displayData(dossier);
    }

    public static void displayFullCatalog(List list) {
        for (Object book : list) {
            System.out.println(book.toString());
        }
    }

    private static void displayData(Dossier dossier) {
        char[] description =  dossier.getData().toCharArray();
        final int stringBreak = 50;
        boolean breaker = false;

        for (int i = 0; i < description.length; i++) {
            if (i % stringBreak == 0 && i != 0) {
                breaker = true;
            }

            if (description[i] == ' ' && breaker) {
                breaker = false;
                description[i] = '\n';
            }
        }

        System.out.println(description);
    }

    public static boolean checkAction(String ActionName, Object entity) {
        if (entity == null) {
            System.out.println(ActionName + " failed");
            return false;
        }

        System.out.println(ActionName + " successful");

        return true;
    }
}