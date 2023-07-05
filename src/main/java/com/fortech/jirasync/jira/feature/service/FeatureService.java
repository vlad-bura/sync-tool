package com.fortech.jirasync.jira.feature.service;

import com.fortech.jirasync.jira.JiraConfig;
import com.fortech.jirasync.jira.api.JiraRequestService;
import com.fortech.jirasync.jira.api.dto.feature.JiraFeatureDTO;
import com.fortech.jirasync.jira.feature.api.exception.CouldNotGetFeatureFromJiraException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FeatureService {

    private static final String REST_API_2_SEARCH = "/rest/api/2/search";

    private final JiraConfig jiraConfig;
    private final JiraRequestService jiraRequestService;


    public String getFeatures(JiraFeatureDTO jiraFeatureDto) {
        String url = jiraConfig.getUrl() + REST_API_2_SEARCH;
        try {
            ResponseEntity<String> responseEntity =
                    jiraRequestService.performPostRequest(url, jiraFeatureDto, String.class);
            return responseEntity.getBody();
        } catch (Exception e) {
            throw new CouldNotGetFeatureFromJiraException(e.getMessage());
        }
    }


}
