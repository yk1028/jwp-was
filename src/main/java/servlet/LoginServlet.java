package servlet;

import db.DataBase;
import http.request.HttpRequest;
import http.response.HttpResponse;
import model.User;

import static http.HttpHeaders.SET_COOKIE;
import static model.User.USER_ID_KEY;
import static model.User.USER_PASSWORD_KEY;

public class LoginServlet extends AbstractServlet {
    @Override
    protected void doPost(HttpRequest httpRequest, HttpResponse response) {
        String userId = httpRequest.getParam(USER_ID_KEY);
        String password = httpRequest.getParam(USER_PASSWORD_KEY);
        if (login(userId, password)) {
            response.redirect("/index.html");
            response.setHeader(SET_COOKIE, "logined=true; Path=/");
            return;
        }
        response.redirect("/user/login_failed.html");
        response.setHeader(SET_COOKIE, "logined=false; Path=/");
    }

    private boolean login(String userId, String password) {
        User user = DataBase.findUserById(userId);
        return (user != null) && user.matchPassword(password);
    }
}