package com.fortech.jirasync.jira.issue.api;

import com.fortech.jirasync.configuration.utils.JsonUtil;
import com.fortech.jirasync.jira.issue.api.dto.IssueDTO;
import com.fortech.jirasync.jira.api.dto.issue.JiraIssueDTO;
import com.fortech.jirasync.jira.issue.service.IssueService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/jira/issue")
@AllArgsConstructor
public class IssueController {

    private final IssueService issueService;


    @PostMapping
    public ResponseEntity<String> createIssue(@RequestBody IssueDTO issueDto) {
        try {
            JiraIssueDTO jiraIssue = JiraIssueDTO.fromIssueDTO(issueDto);
            // Convert the JiraIssue to JSON and send as the request body
            var createdIssue = issueService.createJiraIssue(jiraIssue);
            return ResponseEntity.ok(JsonUtil.serialize(createdIssue));
        } catch (Exception e) {
            // Handle exception and return appropriate response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating issue: " + e.getMessage());
        }

    }


    @GetMapping("/{issueKey}")
    public ResponseEntity<String> getIssue(@PathVariable String issueKey) {
        String issueDetails = issueService.getIssue(issueKey);
        return ResponseEntity.ok(issueDetails);
    }
}