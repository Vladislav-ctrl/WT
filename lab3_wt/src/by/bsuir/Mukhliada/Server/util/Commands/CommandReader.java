package by.bsuir.Mukhliada.Server.util.Commands;

import by.bsuir.Mukhliada.Server.util.Commands.MainCommands.*;
import java.util.HashMap;

public class CommandReader {
    private HashMap<String, MainCommand> commandMap;

    public CommandReader() {
        commandMap = fillCommandMap();
    }

    private HashMap<String, MainCommand> fillCommandMap() {
        HashMap<String, MainCommand> tempCommandMap = new HashMap<>();

        tempCommandMap.put("register", new Registration());
        tempCommandMap.put("login", new LogIn());
        tempCommandMap.put("getUserById", new getUser());
        // tempCommandMap.put("deleteUser", new getAllDossiers());

        //TODO: ADD SEARCH

        tempCommandMap.put("createDossier", new AddDossier());
        tempCommandMap.put("deleteDossier", new DeleteDossier());
        tempCommandMap.put("getDossierById", new getDossier());
        tempCommandMap.put("getAllDossiers", new getAllDossiers());
        tempCommandMap.put("updateDossier", new EditDossier());

        return tempCommandMap;
    }

    public MainCommand getCommand(String command) {
        return commandMap.get(command);
    }
}
