package com.fortech.jirasync.jira.issue.api;

import com.fortech.jirasync.jira.issue.api.dto.IssueDTO;
import com.fortech.jirasync.jira.issue.api.dto.JiraIssueDTO;
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
    public ResponseEntity<?> createIssue(@RequestBody IssueDTO issueDto) {
        try {
            JiraIssueDTO jiraIssue = JiraIssueDTO.fromIssueDTO(issueDto);
            var createdIssueKey = issueService.createJiraIssue(jiraIssue).getKey();
            JiraIssueDTO createdIssue = issueService.getIssue(createdIssueKey);
            return ResponseEntity.ok(IssueDTO.from(createdIssue));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating issue: " + e.getMessage());
        }

    }

    @GetMapping("/{issueKey}")
    public ResponseEntity<IssueDTO> getIssue(@PathVariable String issueKey) {
        JiraIssueDTO jiraIssueDTO = issueService.getIssue(issueKey);
        return ResponseEntity.ok(IssueDTO.from(jiraIssueDTO));
    }
}