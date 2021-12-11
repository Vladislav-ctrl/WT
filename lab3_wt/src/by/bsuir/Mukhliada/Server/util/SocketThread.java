package by.bsuir.Mukhliada.Server.util;

import by.bsuir.Mukhliada.Client.util.BaseClasses.Users.Roles;
import by.bsuir.Mukhliada.Client.util.BaseClasses.Users.User;
import by.bsuir.Mukhliada.Client.util.BaseClasses.Message;
import by.bsuir.Mukhliada.Server.util.Commands.CommandReader;
import by.bsuir.Mukhliada.Server.util.Commands.MainCommand;
import by.bsuir.Mukhliada.Server.util.Controllers.Controller;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketThread extends Thread {
    private Socket fromClientSocket;
    private Controller controller;

    public SocketThread(Socket fromClientSocket, Controller controller) {
        this.controller = controller;
        this.fromClientSocket = fromClientSocket;
    }

    @Override
    public void run() {
        CommandReader commandReader = new CommandReader();
        Gson gson = new Gson();

        try (Socket localSocket = fromClientSocket;
             PrintWriter printWriter = new PrintWriter(localSocket.getOutputStream(), true);
             BufferedReader bufferedReader =
                     new BufferedReader(new InputStreamReader(localSocket.getInputStream())))
        {

            String strMessage;
            while ((strMessage = bufferedReader.readLine()) != null) {

                System.out.println("The message: " + strMessage);

                if (strMessage.equals("exit")) {
                    break;
                }

                Message message = gson.fromJson(strMessage, Message.class);
                MainCommand mainCommand = commandReader.getCommand(message.command);
                if (mainCommand != null) {
                    boolean adminRights = isAdmin(gson.fromJson(message.user, User.class));
                    strMessage = mainCommand.Execute(controller, message.parameter, adminRights);
                    printWriter.println(strMessage);
                } else {
                    printWriter.println("Wrong command!");
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            synchronized (this) {
                controller.dossierController.save();
                controller.userController.save();
            }
        }
    }

    private boolean isAdmin(User user) {
        if (user == null) {
            return false;
        }
        return user.getRole() == Roles.Administrator;
    }
}
