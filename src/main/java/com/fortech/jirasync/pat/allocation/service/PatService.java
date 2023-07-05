package com.fortech.jirasync.pat.allocation.service;

import com.fortech.jirasync.pat.allocation.api.dto.AuthenticationRequest;
import com.fortech.jirasync.pat.allocation.api.dto.AuthenticationResponse;
import com.fortech.jirasync.pat.allocation.api.dto.PtoResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class PatService {

    public final RestTemplate restTemplate;

    public AuthenticationResponse getBearerToken() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        AuthenticationRequest authenticationRequest = new AuthenticationRequest("forecasttimesheet", "")git;
        HttpEntity<AuthenticationRequest> request = new HttpEntity<>(authenticationRequest, headers);
        ResponseEntity<AuthenticationResponse> response = restTemplate.exchange(
                "https://peopleallocation.fortech.ro:5008/api/users/auth/login",
                HttpMethod.POST,
                request,
                AuthenticationResponse.class
        );
        return response.getBody();
    }
}
