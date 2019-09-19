package http.request;

import http.HttpHeaders;
import http.HttpUrl;
import http.HttpVersion;

public class HttpRequest {
    private HttpRequestLine requestLine;
    private HttpHeaders headers;
    private String body;

    HttpRequest(HttpRequestLine requestLine, HttpHeaders headers, String body) {
        this.requestLine = requestLine;
        this.headers = headers;
        this.body = body;
    }

    public HttpMethod getMethod() {
        return requestLine.getMethod();
    }

    public HttpUrl getUrl() {
        return requestLine.getUrl();
    }

    public HttpVersion getVersion() {
        return requestLine.getVersion();
    }

    public HttpHeaders getHeaders() {
        return headers;
    }

    public QueryParams getQueryParams() {
        if (HttpMethod.GET.match(requestLine.getMethod())) {
            return QueryParams.of(requestLine.getUrl().getQueryParams());
        }
        return QueryParams.of(body);
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return requestLine + "\n" + headers + "\n";
    }
}