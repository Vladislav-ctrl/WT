package by.bsuir.Mukhliada.util.Commands;

import by.bsuir.Mukhliada.util.BaseClasses.Books.BookType;

import java.util.HashMap;

public class CommandReader {
    private java.util.Scanner scanner;

    private HashMap<String, Commands> commandMap;
    private HashMap<String, ModCommands> modCommandMap;

    private HashMap<String, Commands> fillCommandMap() {
        HashMap<String, Commands> tempCommandMap = new HashMap<>();

        for(Commands cmd : Commands.values())
            tempCommandMap.put(cmd.toString(), cmd);

        return tempCommandMap;
    }

    private HashMap<String, ModCommands> fillModCommandMap() {
        HashMap<String, ModCommands> tempModCommandMap = new HashMap<>();

        for(ModCommands cmd : ModCommands.values())
            tempModCommandMap.put(cmd.toString(), cmd);

        return tempModCommandMap;
    }

    public CommandReader()
    {
        scanner = new java.util.Scanner(System.in);
        commandMap = fillCommandMap();
        modCommandMap = fillModCommandMap();
    }

    public Commands getCommand() {
        while (true) {
            String cmdStr = getLine();
            Commands cmd = commandMap.get(cmdStr);

            if (!(cmd == null)) {
                return cmd;
            }

            System.out.print(("No such command. Enter again: "));
        }
    }

    public ModCommands getModCommand() {
        while (true) {
            String cmdStr = getLine();
            ModCommands cmd = modCommandMap.get(cmdStr);

            if (!(cmd == null)) {
                return cmd;
            }

            System.out.print(("No such command. Enter again: "));
        }
    }

    public boolean getAnswer(){
        System.out.print("Enter answer(Y/N): ");
        while(true){
            String answer = getLine();
            if (answer.equals("Y")){
                return true;
            }
            else if (answer.equals("N")){
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

    public String getBookTitle(){
        while (true) {
            System.out.print("Enter book title: ");
            String title = getLine().trim();
            if (!title.isEmpty()) {
                return title;
            }
            System.out.println("Field cannot be empty!");
        }
    }

    public String getBookAuthor(){
        while (true) {
            System.out.print("Enter book author: ");
            String author = getLine().trim();
            if (!author.isEmpty()) {
                return author;
            }
            System.out.println("Field cannot be empty!");
        }
    }

    public String getBookDescription(){
        System.out.print("Enter book description: ");
        return getLine().trim();
    }

    public BookType getBookType(){
        System.out.print("Enter book type(Paper/Electronic): ");
        while (true){
            String type = getLine();

            if (type.equals("Paper")){
                return BookType.Paper;
            }
            else if (type.equals("Electronic")){
                return BookType.Electronic;
            }

            System.out.print(("No such book type. Enter again: "));
        }
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
