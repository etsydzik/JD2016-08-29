package by.it.tsydzik.project.java.controller;

import by.it.tsydzik.project.java.beans.Client;
import by.it.tsydzik.project.java.custom_dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

/**
 * @author Eugene Tsydzik
 * @since 02.11.2016.
 */
public class CmdSignUp extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        if (Form.isPost(req)) {
            Client client = new Client();
            try {
                client.setName(Form.getParameter(req, "name", Patterns.LOGIN));
                client.setPassword(Form.getParameter(req, "password", Patterns.PASSWORD));
                DAO dao = DAO.getDAO();
                if (dao.client.create(client)) {
                    return Actions.LOGIN.action;
                } else {
                    Form.showError(req, "Incorrect error");
                    return null;
                }
            } catch (ParseException e) {
                Form.showError(req, "Incorrect data");
                return null;
            }
        }
        return null;
    }
}
