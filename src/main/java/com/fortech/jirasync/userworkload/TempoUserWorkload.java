package com.fortech.jirasync.userworkload;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fortech.jirasync.userworkload.api.UserWorkloadController;
import com.fortech.jirasync.userworkload.api.dto.Root;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;


@Slf4j
@RestController
@RequestMapping("/api/workload/")
@AllArgsConstructor
public class TempoUserWorkload implements UserWorkloadController {

    private final RestTemplate restTemplate;

    @Override
    public String getUserWorkload() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));
        HttpEntity<?> entity = new HttpEntity<>(headers);
        String url =  "https://ijira.fortech.ro/plugins/servlet/tempo-getWorklog/";
        String urlTemplate = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("tempoApiToken", "")
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
        JSONObject json= XML.toJSONObject(response.getBody());
        ObjectMapper om = new ObjectMapper();
        try {
            Root root = om.readValue(json.toString(), Root.class);
            root.getWorklogs().getWorklog().forEach(s->log.info(s.toString()));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return json.toString();
    }
}
