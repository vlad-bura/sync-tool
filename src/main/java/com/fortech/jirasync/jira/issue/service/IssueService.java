package com.fortech.jirasync.jira.issue.service;

import com.fortech.jirasync.jira.config.JiraConfig;
import com.fortech.jirasync.jira.config.JiraRequestService;
import com.fortech.jirasync.configuration.utils.JsonUtil;
import com.fortech.jirasync.jira.issue.api.dto.JiraIssueDTO;
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

    public JiraIssueDTO createJiraIssue(JiraIssueDTO issue) {
        String url = jiraConfig.getUrl() + REST_API_2_ISSUE;
        ResponseEntity<JiraIssueDTO> response = jiraRequestService.performPostRequest(url, issue, JiraIssueDTO.class);
        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("Failed creating JIRA issue: " + JsonUtil.serialize(issue));
        }
        return response.getBody();
    }

    public JiraIssueDTO getIssue(String issueKey) {
        String url = jiraConfig.getUrl() + REST_API_2_ISSUE + issueKey;
        ResponseEntity<JiraIssueDTO> responseEntity = jiraRequestService.performGetRequest(url, JiraIssueDTO.class);
        return responseEntity.getBody();
    }
}
