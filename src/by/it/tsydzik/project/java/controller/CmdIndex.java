package by.it.tsydzik.project.java.controller;


import by.it.tsydzik.project.java.beans.Client;
import by.it.tsydzik.project.java.custom_dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdIndex extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        DAO dao = DAO.getDAO();
        List<Client> ads = dao.client.getAll("");
        req.setAttribute("ads", ads);
        return null;
    }
}
