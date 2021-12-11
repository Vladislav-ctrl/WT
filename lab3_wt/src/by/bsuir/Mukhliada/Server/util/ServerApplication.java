package by.bsuir.Mukhliada.Server.util;

import by.bsuir.Mukhliada.Server.util.Controllers.Controller;
import by.bsuir.Mukhliada.Server.util.Controllers.DossierController;
import by.bsuir.Mukhliada.Server.util.Controllers.UserController;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApplication {
    public ServerApplication() { }

    public void Run() {
        int port = 1777;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            Controller controller = new Controller(new UserController(), new DossierController());

            while (true) {
                System.out.println("Waiting for a connection on " + port);
                Socket fromClientSocket = serverSocket.accept();
                new SocketThread(fromClientSocket, controller).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
