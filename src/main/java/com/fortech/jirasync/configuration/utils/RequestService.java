package com.fortech.jirasync.configuration.utils;

import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public abstract class RequestService {

    private final RestTemplate restTemplate;

    protected abstract String getUsername();

    protected abstract String getToken();

    protected <T> HttpEntity<T> createRequestEntity(T body) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBasicAuth(getUsername(), getToken());
        return new HttpEntity<>(body, headers);
    }

    public <R> ResponseEntity<R> performGetRequest(String url, Class<R> responseType) {
        HttpEntity<?> requestEntity = createRequestEntity(null);
        return restTemplate.exchange(url, HttpMethod.GET, requestEntity, responseType);
    }

    public <T, R> ResponseEntity<R> performPostRequest(String url, T requestBody, Class<R> responseType) {
        HttpEntity<T> requestEntity = createRequestEntity(requestBody);
        return restTemplate.exchange(url, HttpMethod.POST, requestEntity, responseType);
    }

    public void performDeleteRequest(String url) {
        HttpEntity<?> requestEntity = createRequestEntity(null);
        restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class);
    }
}