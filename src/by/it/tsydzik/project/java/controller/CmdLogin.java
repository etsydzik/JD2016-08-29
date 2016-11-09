package by.it.tsydzik.project.java.controller;

import by.it.tsydzik.jd03_03.beans.Client;
import by.it.tsydzik.project.java.beans.User;
import by.it.tsydzik.project.java.custom_dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.List;

/**
 * @author Eugene Tsydzik
 * @since 02.11.2016.
 */
public class CmdLogin extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        if (Form.isPost(req)) {
            User user = new User();
            try {
                //TODO тут добавлять свои beans (client) и к ним уже всё делать, а не user!!!!!!!!!!!!!!!!!!!
                user.setLogin(Form.getParameter(req, "Login", Patterns.LOGIN));
                user.setPassword(Form.getParameter(req, "Password", Patterns.PASSWORD));
                user.setFk_Role(2);
                DAO dao = DAO.getDAO();
                List<Client> users = dao.client.getAll(String.format("WHERE Login='%s' and Password='%s'",
                        user.getLogin(),
                        user.getPassword()
                ));
                if (users.size() == 1) {
                    // пользователь существует
                    //сохранить в сессию
                    user = users.get(0);
                    HttpSession session = req.getSession();
                    session.setAttribute("user", user);
                    return Actions.PROFILE.action;
                } else {
                    Form.showError(req, "USER not found");
                }
            } catch (ParseException e) {
                Form.showError(req, "Incorrect data");
                return null;
            }
        }
        return null;
    }
}
