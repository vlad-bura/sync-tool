package com.fortech.jirasync.jira.issue.controller.impl;

import com.fortech.jirasync.jira.issue.api.IssueController;
import com.fortech.jirasync.jira.issue.api.dto.IssueDTO;
import com.fortech.jirasync.jira.issue.jira.JiraIssue;
import com.fortech.jirasync.jira.issue.mapper.IssueMapper;
import com.fortech.jirasync.jira.issue.service.IssueService;
import com.fortech.jirasync.configuration.utils.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/jira/issue")
@AllArgsConstructor
public class JiraIssueController implements IssueController {

    private final IssueService issueService;
    private IssueMapper issueMapper;


    @Override
    public ResponseEntity<String> createIssue(IssueDTO issueDto) {
        try {
            JiraIssue jiraIssue = issueMapper.toJiraIssue(issueDto);
            // Convert the JiraIssue to JSON and send as the request body
            var createdIssue = issueService.createJiraIssue(jiraIssue);
            return ResponseEntity.ok(JsonUtil.serialize(createdIssue));
        } catch (Exception e) {
            // Handle exception and return appropriate response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating issue: " + e.getMessage());
        }

    }


    @Override
    public ResponseEntity<String> getIssue(String issueKey) {
        String issueDetails = issueService.getIssue(issueKey);
        return ResponseEntity.ok(issueDetails);
    }
}