package by.it.tsydzik.project.java.controller;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eugene Tsydzik
 * @since 02.11.2016.
 */
public enum Actions {
    INDEX {{
        this.action = new CmdIndex();
    }},
    SIGNUP {{
        this.action = new CmdSignUp();
    }},
    LOGIN {{
        this.action = new CmdLogin();
    }},
    PROFILE {{
        this.action = new CmdProfile();
    }},
    ERROR {{
        this.action = new CmdError();
    }};

    protected Action action = null;

    //TODO
    //Factory -> вынести в отдельный класс и назвать FactoryAction!!!!!!!
    static Action defineFrom(HttpServletRequest req) {
        Action res = INDEX.action;
        String command = req.getParameter("command");
        if (command != null && !command.isEmpty())
            try {
                res = Actions.valueOf(command.toUpperCase()).action;
            } catch (Exception e) {
                //
                res = ERROR.action;
            }
        return res;
    }

}
