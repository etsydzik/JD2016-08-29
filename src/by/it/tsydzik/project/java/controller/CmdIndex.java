package by.it.tsydzik.project.java.controller;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdIndex extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        DAO dao=DAO.getDAO();
        List<Ad> ads=dao.ad.getAll("");
        req.setAttribute("ads",ads);
        return null;
    }
}
