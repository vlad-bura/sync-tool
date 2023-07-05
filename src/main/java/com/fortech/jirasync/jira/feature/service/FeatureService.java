package com.fortech.jirasync.jira.feature.service;

import com.fortech.jirasync.configuration.utils.JsonUtil;
import com.fortech.jirasync.jira.config.JiraConfig;
import com.fortech.jirasync.jira.config.JiraRequestService;
import com.fortech.jirasync.jira.feature.api.dto.FeatureRequestDto;
import com.fortech.jirasync.jira.feature.api.dto.FeatureResponseDto;
import com.fortech.jirasync.jira.feature.api.exception.FeatureNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeatureService {

    private static final String REST_API_2_SEARCH = "/rest/api/2/search";

    private final JiraConfig jiraConfig;
    private final JiraRequestService jiraRequestService;


    public FeatureResponseDto searchFeature(FeatureRequestDto jiraFeatureRequestDto) {
        String url = jiraConfig.getUrl() + REST_API_2_SEARCH;
        try {
            ResponseEntity<String> responseEntity =
                    jiraRequestService.performPostRequest(url, jiraFeatureRequestDto, String.class);
            return JsonUtil.deserialize(responseEntity.getBody(), FeatureResponseDto.class);
        } catch (Exception e) {
            throw new FeatureNotFoundException(e.getMessage());
        }
    }
}
