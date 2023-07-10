package com.fortech.jirasync.jira.issue.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IssueDTO {
    private String projectKey;
    private String issueType;
    private String issueKey;
    private String summary;
    private String description;
    private String assignee;

    public static final IssueDTO from(JiraIssueDTO jiraIssue) {
        return IssueDTO.builder()
                .assignee(jiraIssue.getFields().getAssignee().getName())
                .description(jiraIssue.getFields().getDescription())
                .summary(jiraIssue.getFields().getSummary())
                .issueType(jiraIssue.getFields().getIssueType().getId())
                .projectKey(jiraIssue.getFields().getProject().getKey())
                .issueKey(jiraIssue.getKey())
                .build();
    }
}
