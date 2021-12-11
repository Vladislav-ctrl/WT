package by.bsuir.Mukhliada.Client.util.BaseClasses;

public class Message {
    public String command;
    public String parameter;
    public String user;

    public Message(String command, String parameter, String user) {
        this.command = command;
        this.parameter = parameter;
        this.user = user;
    }
}
