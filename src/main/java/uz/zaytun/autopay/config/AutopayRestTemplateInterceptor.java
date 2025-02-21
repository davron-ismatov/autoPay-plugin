package uz.zaytun.autopay.config;

import uz.zaytun.autopay.constants.Constants;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.util.List;

import static uz.zaytun.autopay.service.impl.AuthorizationServiceImpl.token;

public class AutopayRestTemplateInterceptor implements ClientHttpRequestInterceptor {
    private final List<String> urls = List.of(Constants.LOGIN_API);

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        if (!validateUri(request.getURI().toString())) {
            HttpHeaders headers = request.getHeaders();
            headers.setBearerAuth(token.get().getToken());
        }

        return execution.execute(request, body);
    }

    public boolean validateUri(String uri) {
        return urls.stream().noneMatch(api -> api.contains(uri));
    }
}
