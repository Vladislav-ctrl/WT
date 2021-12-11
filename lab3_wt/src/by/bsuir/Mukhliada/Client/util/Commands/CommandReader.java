package by.bsuir.Mukhliada.Client.util.Commands;

import by.bsuir.Mukhliada.Client.util.Commands.EditingCommands.*;
import by.bsuir.Mukhliada.Client.util.Commands.MainCommands.*;

import java.io.InputStream;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.HashMap;

public class CommandReader {
    private java.util.Scanner scanner;
    private HashMap<String, MainCommand> commandMap;
    private HashMap<String, UpdateCommand> updateCommandMap;

    public CommandReader(InputStream inputStream) {
        scanner = new java.util.Scanner(inputStream);
        commandMap = fillCommandMap();
        updateCommandMap = fillUpdateCommandMap();
    }

    private HashMap<String, MainCommand> fillCommandMap() {
        HashMap<String, MainCommand> tempCommandMap = new HashMap<>();

        tempCommandMap.put("add", new AddDossier());
        tempCommandMap.put("delete", new DeleteDossier());
        tempCommandMap.put("display dossier", new DisplayDossier());
        tempCommandMap.put("display all", new DisplayDossiers());
        tempCommandMap.put("edit", new EditDossier());
        tempCommandMap.put("exit", new Exit());
        tempCommandMap.put("help", new Help());

        return tempCommandMap;
    }

    private HashMap<String, UpdateCommand> fillUpdateCommandMap() {
        HashMap<String, UpdateCommand> tempUpdateCommandMap = new HashMap<>();

        tempUpdateCommandMap.put("help", new HelpUpdating());
        tempUpdateCommandMap.put("stop", new StopUpdating());
        tempUpdateCommandMap.put("birthdate", new UpdateBirthDate());
        tempUpdateCommandMap.put("data", new UpdateData());
        tempUpdateCommandMap.put("name", new UpdateName());
        tempUpdateCommandMap.put("secondname", new UpdateSecondname());
        tempUpdateCommandMap.put("surname", new UpdateSurname());

        return tempUpdateCommandMap;
    }

    public MainCommand getCommand() {
        while (true) {
            String cmdStr = getLine().toLowerCase().trim();
            MainCommand cmd = commandMap.get(cmdStr);

            if (cmd != null) {
                return cmd;
            }

            System.out.print(("No such command. Enter again: "));
        }
    }

    public UpdateCommand getUpdateCommand() {
        while (true) {
            String cmdStr = getLine().toLowerCase().trim();
            UpdateCommand cmd = updateCommandMap.get(cmdStr);

            if (!(cmd == null)) {
                return cmd;
            }

            System.out.print(("No such command. Enter again: "));
        }
    }

    public boolean getAnswer(){
        System.out.print("Enter answer(Y/N): ");
        while(true){
            String answer = getLine().toLowerCase().trim();
            if (answer.equals("y")){
                return true;
            }
            else if (answer.equals("n")){
                return false;
            }
            else{
                System.out.print(("Wrong answer. Enter again: "));
            }
        }
    }

    public String getLine() {
        String line = scanner.nextLine().trim();

        while (line.isEmpty()) {
            System.out.print(("Line cannot be empty. Enter again: "));
            line = scanner.nextLine().trim();
        }

        return line;
    }

    public String getFullName(String input){
        while (true) {
            System.out.print("Enter " + input + ": ");
            String line = getLine().trim();
            if (!line.isEmpty()) {
                return line;
            }
            System.out.println("Field cannot be empty!");
        }
    }

    public LocalDate getDate(){
        LocalDate localDate = null;
        boolean incorrectDate = true;

        while(incorrectDate) {
            int data[] = new int[3];
            boolean error = true;
            System.out.println("Enter date of birth:");
            for (int i = 0; i < 3; i++) {
                switch (i) {
                    case 0:
                        System.out.print("Enter year: ");
                        break;
                    case 1:
                        System.out.print("Enter month: ");
                        break;
                    case 2:
                        System.out.print("Enter day: ");
                        break;
                }
                while (error) {
                    try {
                        error = false;
                        data[i] = scanner.nextInt();
                    } catch (Exception e) {
                        error = true;
                        scanner.next();
                        System.out.print("Incorrect input.\nEnter number again: ");
                    }
                }

                error = true;
            }

            try{
                localDate = LocalDate.of(data[0], data[1], data[2]);
                incorrectDate = false;
            }catch (DateTimeException e) {
                System.out.println("Incorrect date.\nTry again.");
            }
        }

        return localDate;
    }

    public String getData(){
        System.out.print("Enter data in one line: ");
        return getLine().trim();
    }


    public int getID(){
        System.out.print("Enter ID: ");
        int result;

        while(true) {
            try {
                result = scanner.nextInt();
                return result;
            } catch (Exception e) {
                scanner.next();
                System.out.print("Incorrect input.\nEnter number again: ");
            }
        }
    }

    public String getUserEmail(){
        while (true) {
            System.out.print("Enter Email: ");
            String email = getLine().trim();
            if (!email.isEmpty()) {
                return email;
            }
            System.out.println("Field cannot be empty!");
        }
    }

    public String getUserPassword(){
        while (true) {
            System.out.print("Enter password: ");
            String password = getLine().trim();
            if (!password.isEmpty()) {
                return password;
            }
            System.out.println("Field cannot be empty!");
        }
    }
}
