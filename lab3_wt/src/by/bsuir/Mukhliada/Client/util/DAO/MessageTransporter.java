package by.bsuir.Mukhliada.Client.util.DAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MessageTransporter {

    private String IPadress = "127.0.0.1";
    private int port = 1777;

    private BufferedReader bufferedReader;
    private PrintWriter printWriter;
    private Socket socket;

    public MessageTransporter() throws IOException {
        socket = new Socket(IPadress, port);
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        printWriter = new PrintWriter(socket.getOutputStream(), true);
    }


    public void SendMessage(String message) {
        printWriter.println(message);
    }

    public String GetAnswer() {
        String message = "";
        try {
            message = bufferedReader.readLine();
        } catch (Exception e) {
            System.out.println("Error in dossier GetAnswer");
        }
        return message;
    }

    public void close() throws IOException {
        bufferedReader.close();
        printWriter.close();
        socket.close();
    }
}
