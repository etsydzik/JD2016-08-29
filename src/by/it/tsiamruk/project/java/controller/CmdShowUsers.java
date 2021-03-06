package by.it.tsiamruk.project.java.controller;

import by.it.tsiamruk.project.java.DAO.SingletonDAO;
import by.it.tsiamruk.project.java.beans.Account;
import by.it.tsiamruk.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by waldemar on 02/11/2016.
 */
public class CmdShowUsers extends Action {

    @Override
    Action execute(HttpServletRequest req) {
        SingletonDAO dao = SingletonDAO.getDAO();
        List<User> users = dao.user.getAll("");
        req.setAttribute("users", users);
        List<Account> accounts = dao.account.getAll("");
        req.setAttribute("accounts", accounts);
        return null;
    }
}
