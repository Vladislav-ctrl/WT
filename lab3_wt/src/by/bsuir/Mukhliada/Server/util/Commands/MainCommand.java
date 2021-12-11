package by.bsuir.Mukhliada.Server.util.Commands;

import by.bsuir.Mukhliada.Server.util.Controllers.Controller;

public interface MainCommand {
    String Execute(Controller controller, String parameter, boolean adminPrivileges);
}
