package com.fortech.jirasync.tempo.userworkload.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fortech.jirasync.tempo.userworkload.api.UserWorkloadController;
import com.fortech.jirasync.tempo.userworkload.api.dto.WorkloadResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Objects;


@Slf4j
@RestController
@RequestMapping("/api/workload/")
@AllArgsConstructor
public class TempoUserWorkload implements UserWorkloadController {

    private final RestTemplate restTemplate;

    @Override
    public WorkloadResponse getUserWorkload() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<?> entity = new HttpEntity<>(headers);
        String url =  "https://ijira.fortech.ro/plugins/servlet/tempo-getWorklog/";
        String urlTemplate = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("tempoApiToken", "08ea4d6f-8d92-4c01-b9f7-16e936196f45")
                .queryParam("dateFrom", "2023-07")
                .queryParam("addIssueDetails", "true")
                .queryParam("format", "xml")
                .queryParam("diffOnly", "false")
                .queryParam("dateTo", "2023-07-31")
                .queryParam("userName", "vlad.bura")
                .encode()
                .toUriString();
        ResponseEntity<String> response = restTemplate.exchange(
                urlTemplate,
                HttpMethod.GET,
                entity,
                String.class
        );
        JSONObject json= XML.toJSONObject(Objects.requireNonNull(response.getBody()));
        ObjectMapper om = new ObjectMapper();
        try {
            WorkloadResponse workloadResponse = om.readValue(json.toString(), WorkloadResponse.class);
            workloadResponse.getWorklogs().getWorklog().forEach(s->log.info(s.toString()));
            return workloadResponse;
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
