package by.bsuir.Mukhliada.Client.util;

import by.bsuir.Mukhliada.Client.util.Commands.MainCommand;
import by.bsuir.Mukhliada.Client.util.Commands.CommandReader;
import by.bsuir.Mukhliada.Client.util.Controllers.*;


public class ClientApplication {

    private Controller controller;
    private CommandReader console;

    public ClientApplication() {
        console = new CommandReader(System.in);
        controller = new Controller(
                     new DossierController(console),
                     new UserController(console));
    }

    public void Run() {
        //controller.currentUser = controller.userController.getAdmin();

        while(controller.currentUser == null) {
            System.out.println("Do you want to register?");
            if (console.getAnswer()) {
                controller.userController.registration();
            } else {
                controller.currentUser = controller.userController.logIn();
            }
        }

        while (!controller.exitApplication){
            System.out.print("Type command: ");
            MainCommand cmd = console.getCommand();
            cmd.Execute(controller);
        }
    }
}

