package by.it.tsydzik.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

/**
 * @author Eugene Tsydzik
 * @since 02.11.2016.
 */
public class Form {
    static String getParameter(HttpServletRequest req, String name, String pattern) throws ParseException {
        // данные из формы
        String value = req.getParameter(name);
        if ((value != null) && value.matches(pattern)) {
            return value;
        } else {
            throw new ParseException("Incorrect String" + name, 0);
        }
    }

    static boolean isPost(HttpServletRequest req) {
        return req.getMethod().equalsIgnoreCase("POST");
    }

    static void showMessage(HttpServletRequest req, String message) {
        req.setAttribute(Messages.MESSAGE, message);
    }


    static void showError(HttpServletRequest req, String error) {
        req.setAttribute(Messages.MESSAGE_ERROR, error);
    }
}
