package by.it.tsydzik.project.java.controller;

import by.it.tsydzik.project.java.beans.Client;
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
            Client client = new Client();
            try {
                client.setName(Form.getParameter(req, "name", Patterns.LOGIN));
                client.setPassword(Form.getParameter(req, "password", Patterns.PASSWORD));
                DAO dao = DAO.getDAO();
                List<Client> users = dao.client.getAll(String.format("WHERE name='%s' and password='%s'",
                        client.getName(),
                        client.getPassword()
                ));
                if (users.size() == 1) {
                    // пользователь существует
                    //сохранить в сессию
                    client = users.get(0);
                    HttpSession session = req.getSession();
                    session.setAttribute("client", client);
                    return Actions.PROFILE.action;
                } else {
                    Form.showError(req, "CLIENT not found");
                }
            } catch (ParseException e) {
                Form.showError(req, "Incorrect data");
                return null;
            }
        }
        return null;
    }
}
