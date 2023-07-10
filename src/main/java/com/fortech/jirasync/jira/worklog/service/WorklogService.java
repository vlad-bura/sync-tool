package com.fortech.jirasync.jira.worklog.service;

import com.fortech.jirasync.jira.config.JiraConfig;
import com.fortech.jirasync.jira.config.JiraRequestService;
import com.fortech.jirasync.jira.worklog.api.dto.WorklogDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.fortech.jirasync.jira.issue.service.IssueService.REST_API_2_ISSUE;

@Service
@Slf4j
@AllArgsConstructor
public class WorklogService {

    public static final String WORKLOG = "/worklog";

    private final JiraConfig jiraConfig;
    private final JiraRequestService jiraRequestService;



    public WorklogDTO getWorklog(String issueKey) {
        String url = jiraConfig.getUrl() + REST_API_2_ISSUE + issueKey + WORKLOG;
        ResponseEntity<WorklogDTO> responseEntity = jiraRequestService.performGetRequest(url, WorklogDTO.class);
        return responseEntity.getBody();
    }
}
