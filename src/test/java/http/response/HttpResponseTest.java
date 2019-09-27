package http.response;

import http.HttpHeaders;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static http.HttpVersion.DEFAULT_VERSION;
import static http.response.HttpStatus.*;
import static org.assertj.core.api.Assertions.assertThat;

public class HttpResponseTest {
    @Test
    @DisplayName("redirect시 response 테스트")
    void redirect() {
        String location = "location";
        HttpResponse httpResponse = new HttpResponse(DEFAULT_VERSION);

        httpResponse.redirect(location);

        assertThat(httpResponse.getStatus()).isEqualTo(FOUND);
        assertThat(httpResponse.getHeaders().getHeader(HttpHeaders.LOCATION)).isEqualTo(location);
        assertThat(httpResponse.getBody()).isEqualTo(null);
    }

    @Test
    @DisplayName("404 error 발생시 response 테스트")
    void error_404() {
        HttpStatus error = NOT_FOUND;
        byte[] errorMessage = error.getMessage().getBytes();
        HttpResponse httpResponse = new HttpResponse(DEFAULT_VERSION);

        httpResponse.error(error);

        assertThat(httpResponse.getStatus()).isEqualTo(NOT_FOUND);
        assertThat(httpResponse.getBody()).isEqualTo(errorMessage);
    }

    @Test
    @DisplayName("405 error 발생시 response 테스트")
    void error_405() {
        HttpStatus error = METHOD_NOT_ALLOWED;
        byte[] errorMessage = error.getMessage().getBytes();
        HttpResponse httpResponse = new HttpResponse(DEFAULT_VERSION);

        httpResponse.error(error);

        assertThat(httpResponse.getStatus()).isEqualTo(METHOD_NOT_ALLOWED);
        assertThat(httpResponse.getBody()).isEqualTo(errorMessage);
    }
}