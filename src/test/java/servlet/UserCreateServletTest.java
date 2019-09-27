package servlet;

import db.DataBase;
import http.request.HttpRequest;
import http.request.HttpRequestFactory;
import http.response.HttpResponse;
import model.User;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

class UserCreateServletTest {
    private static final String TEST_DIRECTORY = "./src/test/resources/";

    private UserCreateServlet userController = new UserCreateServlet();

    @Test
    void user_생성() throws IOException {
        InputStream in = new FileInputStream(new File(TEST_DIRECTORY + "Http_POST.txt"));
        HttpRequest request = HttpRequestFactory.makeHttpRequest(in);
        HttpResponse response = new HttpResponse(request.getVersion());
        userController.doPost(request, response);

        User user = DataBase.findUserById("woowa");

        assertThat(user.getUserId()).isEqualTo("woowa");
        assertThat(user.getEmail()).isEqualTo("woo@w.a");
        assertThat(user.getName()).isEqualTo("woo");
        assertThat(user.getPassword()).isEqualTo("password");
    }
}