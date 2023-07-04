package com.fortech.jirasync.service;

import com.fortech.jirasync.configuration.JiraConfig;
import com.fortech.jirasync.domain.jira.JiraIssue;
import com.fortech.jirasync.utils.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class IssueService {
    public static final String REST_API_2_ISSUE = "/rest/api/2/issue/";
    private final JiraConfig jiraConfig;
    private final JiraRequestService jiraRequestService;

    public JiraIssue createJiraIssue(JiraIssue issue) {
        String url = jiraConfig.getUrl() + REST_API_2_ISSUE;

        ResponseEntity<String> response = jiraRequestService.performPostRequest(url, issue, String.class);

        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("Failed creating JIRA issue: " + JsonUtil.serialize(issue));
        }
        return JsonUtil.deserialize(response.getBody(), JiraIssue.class);
    }

    public String getIssue(String issueKey) {
        String url = jiraConfig.getUrl() + REST_API_2_ISSUE + issueKey;
        ResponseEntity<String> responseEntity = jiraRequestService.performGetRequest(url, String.class);
        return responseEntity.getBody();
    }
}
