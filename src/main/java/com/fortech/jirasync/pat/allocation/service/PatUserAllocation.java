package com.fortech.jirasync.pat.allocation.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fortech.jirasync.pat.allocation.api.UserAllocationController;
import com.fortech.jirasync.pat.allocation.api.dto.AuthenticationRequest;
import com.fortech.jirasync.pat.allocation.api.dto.AuthenticationResponse;
import com.fortech.jirasync.pat.allocation.api.dto.PtoResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Objects;


@Slf4j
@RestController
@RequestMapping("/api/allocation/")
@AllArgsConstructor
public class PatUserAllocation implements UserAllocationController {

    private final RestTemplate restTemplate;
    private final PatService patService;


    @Override
    public PtoResponse getUserAllocation() {
        HttpEntity<?> entity = new HttpEntity<>(getHeaders());
        ResponseEntity<PtoResponse> response = restTemplate.exchange(
                "https://peopleallocation.fortech.ro:5000/api/dashboard/organizations/56/employees/forecasting/ptos",
                HttpMethod.GET,
                entity,
                PtoResponse.class
        );

        return response.getBody();
    }


    HttpHeaders getHeaders(){
        return new HttpHeaders() {{
            set( "Authorization", "Bearer " + patService.getBearerToken() );
        }};
    }

}
